package cn.zhangyu.controller;

import cn.zhangyu.DTO.ResponseDTO;
import cn.zhangyu.bean.*;
import cn.zhangyu.entity.*;
import cn.zhangyu.repository.*;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

/**
 * 开发需求：
 * 所有API 的响应格式如下：
 * {
 *     "errCode": "0",
 *     "errMsg": "请求成功",
 *     "data":
 * }
 *
 * 第一个接口：http://localhost:9020/LLGA/open/api/dataQuery?JobName=KEY_PERSON_TYPE_COUNT
 * 返回数据：{"errCode":0,"errMsg":"请求成功","data":[{"num":9,"keyType":"1"},{"num":3,"keyType":"2"},{"num":7,"keyType":"3"},{"num":8,"keyType":"4"},{"num":5,"keyType":"6"}]}
 *
 * 第二个接口：http://localhost:9020/LLGA/open/api/dataQuery?JobName=QUERY_KEYPERSON_BYTYPE&keyType=1
 *返回数据：{"errCode":0,"errMsg":"请求成功","data":[{"name":"郑飞","id_card":"522730198604120414"},{"lng":"0","name":"周佐云","id_card":"522730197510070415","lat":"0"}]}
 *
 * 第三个接口：http://localhost:9020/LLGA/open/api/dataQuery?JobName=QUERY_PERSON_INFO2&idCard=522730196412171023
 * 返回数据：根据真实数据发现，获取的数据中有三种情况：1只有人员信息2.存在人员信息和酒店信息3. 人员信息、房屋信息和居住地信息，
 * 获取信息的时候需要加上判断。
 *
 * 1.只有人员信息
 * {"data":{"imgUrl":"/upload/car/628d87df3524196ae93a9b64f9f5e824.png","isKeyPerson":"1","nation":"未知","idCard":"52273019630913171X","sex":"1","name":"余元何","keyType":"2","birthDate":"1963-09-13"},"errCode":0,"errMsg":"请求成功"}
 *
 * 2.人员信息和酒店信息
 * {"data":{"isKeyPerson":"1","hotelInfo":[{"roomNum":"202","checkindate":"2017-09-20 20:58:52","name":"陆海","hotelName":"湖南旅社"}],"nation":"未知","idCard":"522730198907082515","sex":"1","name":"陆海","keyType":"3","birthDate":"1989-07-08"},"errCode":0,"errMsg":"请求成功"}
 *
 * 3.人员信息、房屋信息和居住地信息
 * "{"data":{"imgUrl":"/LLGA/userfiles/1/images/photo/2017/12/%E8%B5%B5%E9%98%B3.bmp","isKeyPerson":"1","plateId":"","nation":"未知","idCard":"522322197910040598","sex":"1","name":"赵阳","cardAddr":"贵州省龙里县冠山街道羊角井1号","keyType":"3","birthDate":"1979-10-04","roomInfo":{"address":"羊角井1号","ownerName":"","ownerMobile":"","ownerIdCard":"","roomDwellerInfo":[{"idCard":"522322197910040598","sex":"1","name":"赵阳","mobile":"15870386811"}]}},"errCode":0,"errMsg":"请求成功"}
 *
 * 根据调用第一个接口获取keyType，通过获取的keyType调用第二个接口获取idCard,根据获取的idCard调用第三个接口获取所有信息
 *
 */

@RestController
@RequestMapping(value = "/LLGA")
public class KeyPersonnelController {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private HabitationRepository habitationRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private ErrorIdCardReposity errorIdCardReposity;

    @Value("${url}")
    private String url;

    @Value("${filePath}")
    private String filePath;

    @Value("${imageUrl}")
    private String imageUrl;

    /**
     * http://localhost:9020/LLGA/open/api/dataQuery?JobName=KEY_PERSON_TYPE_COUNT
     * {"errCode":0,"errMsg":"请求成功","data":[{"num":9,"keyType":"1"},{"num":3,"keyType":"2"},{"num":7,"keyType":"3"},{"num":8,"keyType":"4"},{"num":5,"keyType":"6"}]}
     * 重点人员分类统计
     *
     * @return
     */
    @RequestMapping(value = "/getcategory", method = RequestMethod.GET)
    public void getCategory() {
        //获取keyType
        //1.准备url
        String surl = url + "?JobName={name}";
        //System.out.println(surl);
        //2.创建RestTemplate对象
        RestTemplate restTemplate = new RestTemplate();
        //3.准备参数
        Map<String, Object> params = new HashMap<>();
        params.put("name", "KEY_PERSON_TYPE_COUNT");
        //4.自定义一个DTO接收调用第三方接口获取的数据
        /**
         * DTO属性：
         *     private String errCode;
         *     private String errMsg;
         *     private T data;
         */
        ResponseDTO<List<CategoryBean>> responseDTO = new ResponseDTO();
        //5.调用restTemplate.getForObject方法
        responseDTO = restTemplate.getForObject(surl, ResponseDTO.class, params);
        //System.out.println(responseDTO);
        // if (responseDTO.getErrCode()=="0"){
        //  LOG.info(DataPoolLogUtil.toLog("According to keytype query personnel information"));
        //错误的方法 （原因泛型里面传递list<CategoryBean> 解析不出来CategoryBean）
        //List<CategoryBean> list = JSONObject.parseObject(JSONObject.toJSONString(responseDTO.getData()),List.class);
//        ObjectMapper mapper = new ObjectMapper();
//        List<CategoryBean> list = mapper.readValue(responseDTO.getData().toString(), List.class);
        // List<CategoryBean> list = responseDTO.getData();
//        String s = JSONObject.toJSONString(responseDTO.getData());
//        ObjectMapper mapper = new ObjectMapper();
//        List<CategoryBean> beanList = mapper.readValue(s, new TypeReference<List<CategoryBean>>() {});
        //responseDTO.getData()转化为json ,再解析成list
        /**
         * toJSONString(Object object); // 将JavaBean序列化为JSON文本
         * parseArray(String text); // 把JSON文本parse成JSONArray
         */
        List<CategoryBean> keyTypeList = JSONObject.parseArray(JSONObject.toJSONString(responseDTO.getData()), CategoryBean.class);
        ResponseDTO<List<CurPerson>> responseDTO1 = new ResponseDTO<>();
//            Map<String,Object> responseDTO1=new HashMap<>();

        //遍历keyType，根据keyType查詢idcard,每种keytype下面有多个人员
        for (CategoryBean bean : keyTypeList) {
            params.put("name", "QUERY_KEYPERSON_BYTYPE");
            surl = url + "?JobName={name}&keyType={type}";
            params.put("type", bean.getKeyType());
            responseDTO1 = restTemplate.getForObject(surl, ResponseDTO.class, params);
            //System.out.println(responseDTO1);
//            if (responseDTO1==null){
//                 //   LOG.info(DataPoolLogUtil.toLog("responseDTO1 is null"));
//                }
            //数据接收成功，获取idCard，准备写入本地表
            //   LOG.info(DataPoolLogUtil.toLog("Data acquisition success, access data"));
            //CurPerson里面还有经纬度需要保存到PersonEntity
            List<CurPerson> idCardList = JSONObject.parseArray(JSONObject.toJSONString(responseDTO1.getData()), CurPerson.class);
            //遍厉list1得到idCard
            //MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>();
            Map<String, String> params1 = new HashMap<>();
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json;charset=UTF-8");
            HttpEntity<Map<String, String>> r = new HttpEntity<>(params1, headers);
            ResponseDTO<AllInfoBean> responseDTO2 = new ResponseDTO<>();
            for (CurPerson person : idCardList) {
                try {
                    //if (person.getIdCard().equals("522730197503102634")) continue;
                    //http://52.62.1.181:9020/LLGA/open/api/dataQuery?JobName=QUERY_PERSON_INFO2&idCard=522730197506162544
                    //System.out.println(idCardList);
                    /**
                     * 接口三比接口四少了酒店信息
                     */
                    //接口三
                    //paramMap.add("name","QUERY_PERSON_INFO");
                    //接口四
                    surl = url + "?JobName={name}&idCard={idCard}";
                    //System.out.println(surl);
                    //System.out.println("person::id_card:" + person.getIdCard());
                    params1.put("name", "QUERY_PERSON_INFO2");
                    params1.put("idCard", person.getIdCard());
                    //文档中标注的是post请求，但是发送的时候请求异常，本地发送get请求可以
                    //System.out.println("name:" + person.getName());
                    //System.out.println("JobName::" + params1.get("name"));
                    responseDTO2 = restTemplate.getForObject(surl, ResponseDTO.class, params1);
                    //System.out.println(responseDTO2.toString());

                    //判断idCard是否为空
                    //接口文档数据返回不一致
                    /**
                     * {"errCode":0,"errMsg":"请求成功","data":
                     * {"isKeyPerson":"1","nation":"未知","idCard":"522730197506162544",
                     * "sex":"2","name":"杨贵福","cardAddr":"龙里县冠山街道正大街120号","
                     * keyType":"10","birthDate":"1975-06-16"}}
                     */
                    //PersonBean  personBean= JSONObject.parseObject(JSONObject.toJSONString(responseDTO2.getData()), PersonBean.class);
                    //System.out.println(personBean);
//                    //人员实体
//                    PersonEntity personEntity = new PersonEntity();
//                    //保存经纬度信息
//                    personEntity.setLng(personEntity.getLng());
//                    personEntity.setLat(personEntity.getLat());
//                    //保存人员信息
//                    personEntity.setImgUrl(personBean.getImgUrl());
//                    personEntity.setIsKeyPerson(personBean.getIsKeyPerson());
//                    personEntity.setNation(personBean.getNation());
//                    personEntity.setIdCard(personBean.getIdCard());
//                    personEntity.setSex(personBean.getSex());
//                    personEntity.setKeyType(personBean.getKeyType());
//                    personEntity.setName(personBean.getName());
//                    personEntity.setBirthDate(personBean.getBirthDate());
//                    personEntity.setStorage_time(new Date());
//                    personEntity.setCardAddr(personBean.getCardAddr());
//                    personRepository.save(personEntity);

                    AllInfoBean allInfoBean = JSONObject.parseObject(JSONObject.toJSONString(responseDTO2.getData()), AllInfoBean.class);
                    //System.out.println(allInfoBean);

                    //人员实体
                    PersonEntity personEntity = new PersonEntity();
                    //保存经纬度信息
                    personEntity.setLng(personEntity.getLng());
                    personEntity.setLat(personEntity.getLat());
                    //保存图片url
                    String imgUrl = allInfoBean.getImgUrl();
                    if (imageUrl!=null || imageUrl.contains("/")){
                        personEntity.setImgUrl(imgUrl);
                        //截取图片名
                        String imageName = imgUrl.substring(imgUrl.lastIndexOf("/"));
                        System.out.println("filePath+imageName::"+filePath+imageName);
                        personEntity.setImgPath(filePath+imageName);
                    }
                    //人员手机号码，从roominfo获取
                    RoomBean roomBeanMobile = allInfoBean.getRoomInfo();
                    if (roomBeanMobile != null) {
                        personEntity.setMobile(roomBeanMobile.getOwnerMobile());
                    }
                    personEntity.setIsKeyPerson(allInfoBean.getIsKeyPerson());
                    personEntity.setNation(allInfoBean.getNation());
                    personEntity.setIdCard(allInfoBean.getIdCard());
                    personEntity.setSex(allInfoBean.getSex());
                    personEntity.setKeyType(allInfoBean.getKeyType());
                    personEntity.setName(allInfoBean.getName());
                    personEntity.setBirthDate(allInfoBean.getBirthDate());
                    personEntity.setStorageTime(new Date());
                    personEntity.setCardAddr(allInfoBean.getCardAddr());
                    personRepository.save(personEntity);

                    //保存酒店信息

                    List<HotelBean> hotelBeanList = allInfoBean.getHotelInfo();
                    if (hotelBeanList != null && hotelBeanList.size() > 0) {
                        hotelBeanList.forEach(hotelBean -> {
                            //酒店实体
                            HotelEntity hotelEntity = new HotelEntity();
                            hotelEntity.setCheckIndate(hotelBean.getCheckindate());
                            hotelEntity.setCheckOutdate(hotelBean.getCheckoutdate());
                            hotelEntity.setHotelName(hotelBean.getHotelName());
                            hotelEntity.setIdCard(personEntity.getIdCard());
                            hotelEntity.setName(hotelBean.getName());
                            hotelEntity.setRoomNum(hotelBean.getRoomNum());
                            hotelEntity.setStorageTime(new Date());
                            hotelRepository.save(hotelEntity);
                        });
                    }
                    //保存车辆信息
//                    List<CarBean> carBeanList = allInfoBean.getCarInfo();
//                    carBeanList.forEach(carBean -> {
//                        //车辆实体
//                        CarEntiry carEntiry = new CarEntiry();
//                        carEntiry.setCarColor(carBean.getCarColor());
//                        carEntiry.setCarModel(carBean.getCarModel());
//                        carEntiry.setCarManufacturer(carBean.getCarNanufacturer());
//                        carEntiry.setCarNumber(carBean.getCarNumber());
//                        carEntiry.setCarOwnerIdCard(personEntity.getIdCard());
//                        carEntiry.setCarOwnerName(personEntity.getName());
//                        carEntiry.setStorageTime(new Date());
//                        carRepository.save(carEntiry);
//                    });

                    //保存房屋信息
                    RoomBean roomBeanList = allInfoBean.getRoomInfo();
                    RoomEntity roomEntity = new RoomEntity();
                    if (roomBeanList != null) {
                        //房屋实体


                        roomEntity.setAddress(roomBeanList.getAddress());
                        roomEntity.setOwnerIdCard(roomBeanList.getOwnerIdCard());
                        roomEntity.setOwnerMobile(roomBeanList.getOwnerMobile());
                        roomEntity.setOwnerName(roomBeanList.getOwnerName());
                        roomEntity.setStorageTime(new Date());
                        roomRepository.save(roomEntity);

                        //保存居住地信息
                        List<HabitationBean> habitationBeanList = roomBeanList.getRoomDwellerInfo();
                        if (habitationBeanList != null && habitationBeanList.size() > 0) {
                            habitationBeanList.forEach(habitationBean -> {
                                //居住实体
                                HabitationEntity habitationEntity = new HabitationEntity();

                                habitationEntity.setIdCard(habitationBean.getIdCard());
                                habitationEntity.setMobile(habitationBean.getMobile());
                                habitationEntity.setName(habitationBean.getName());
                                habitationEntity.setSex(habitationBean.getSex());
                                habitationEntity.setStorageTime(new Date());
                                habitationEntity.setUuid(roomEntity.getUuid());
                                habitationRepository.save(habitationEntity);
                            });
                        }
                        //保存车辆信息
                        List<CarBean> carBeanList1 = roomBeanList.getCarInfo();
                        if (carBeanList1 != null && carBeanList1.size() > 0) {
                            carBeanList1.forEach(carBean1 -> {
                                //车辆实体
                                CarEntiry carEntiry1 = new CarEntiry();
                                carEntiry1.setCarColor(carBean1.getCarColor());
                                carEntiry1.setCarModel(carBean1.getCarModel());
                                carEntiry1.setCarManufacturer(carBean1.getCarNanufacturer());
                                carEntiry1.setCarNumber(carBean1.getCarNumber());
                                carEntiry1.setCarOwnerIdCard(personEntity.getIdCard());
                                carEntiry1.setCarOwnerName(personEntity.getName());
                                carEntiry1.setStorageTime(new Date());
                                carRepository.save(carEntiry1);
                            });
                        }
                    }
                } catch (Exception e) {
                    ErrorIdCard errorIdCard = new ErrorIdCard();
                    errorIdCard.setIdCard(person.getIdCard());
                    errorIdCard.setStorageTime(new Date());
                    errorIdCardReposity.save(errorIdCard);
                    e.printStackTrace();
                }
            }
        }
    }
//        }else {
//            System.out.println("获取信息失败");
//        }
    //  LOG.info(DataPoolLogUtil.toLog("Classified statistics of key personnel end"));
    // System.out.println("keypersonnelcontroller"+responseDTO.toString());


    /**
     * 根据图片url获取图片
     */
    @RequestMapping(value = "/saveImage")
    public void saveImage() {

        List<PersonEntity> personEntities = personRepository.findAll();
        personEntities.forEach(item -> {
            try {
                StringBuilder s = new StringBuilder(imageUrl);
                if (!item.getImgUrl().startsWith("/LLGA")) {
                    s.append("/LLGA");
                }
                //System.out.println("imageUrl："+s.toString());
                s.append(item.getImgUrl());
                System.out.println(s.toString());
                HttpURLConnection httpURLConnection = null;
                URL restServiceURL;
                restServiceURL = new URL(s.toString());
                httpURLConnection = (HttpURLConnection) restServiceURL.openConnection();
                httpURLConnection.setRequestProperty("Content-Type", "application/json");
                //httpURLConnection.setRequestProperty("Cookie", "BAIDUID=03C2D916488EA5974936B1CC2A96B214:FG=1; BIDUPSID=03C2D916488EA5974936B1CC2A96B214; PSTM=1530595170; BD_UPN=12314753; BDORZ=B490B5EBF6F3CD402E515D22BCDA1598; delPer=0; BD_CK_SAM=1; PSINO=5; H_PS_PSSID=1459_21083_18559_26350_20928; H_PS_645EC=e407Rorgbh1DXZRv%2FLjbxRAH7pon07qJla1wcLknfWR2bnVj94wqVQbG3HQ; BD_HOME=0");
                httpURLConnection.setDoOutput(true);
                //byte[] bytes = IOUtils.toByteArray(httpURLConnection.getInputStream());
                File storageDir = new File(filePath);
                if (!storageDir.exists()) {
                    storageDir.mkdirs();
                }
                String imgName = s.substring(s.lastIndexOf("/"));
                FileOutputStream fileOutputStream = new FileOutputStream(filePath + imgName);
                IOUtils.copy(httpURLConnection.getInputStream(), fileOutputStream);
                //byteArrayOutputStream.write(bytes);
                //System.out.println(bytes);
                fileOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


    /**
     * 根据重点人员类型查询人员地理位置信息
     * http://localhost:9020/LLGA/open/api/dataQuery?JobName=QUERY_KEYPERSON_BYTYPE&keyType=1
     * <p>
     * {"errCode":0,"errMsg":"请求成功","data":[{"name":"郑飞","id_card":"522730198604120414"},{"lng":"0","name":"周佐云","id_card":"522730197510070415","lat":"0"}]}
     *
     * @return
     */
//    @RequestMapping(value = "/getlocation", method = RequestMethod.GET)
//    public void getIdCard(@RequestParam(value = "JobName") String JobName, @RequestParam(value = "keyType") Integer keyType) {
//
//        //  LOG.info(DataPoolLogUtil.toLog("Query personnel geographic information start"));
//        String url = "http://localhost:9020/LLGA/open/api/dataQuery?JobName={name}&keyType={type}";
//        RestTemplate restTemplate = new RestTemplate();
//        Map<String, Object> params = new HashMap<>();
//        params.put("name", JobName);
//        params.put("type", keyType);
//        ResponseDTO<List<CurPerson>> responseDTO = new ResponseDTO<>();
    //    responseDTO = restTemplate.getForObject(url, ResponseDTO.class, params);
//        if (responseDTO==null){
//         //   LOG.info(DataPoolLogUtil.toLog("responseDTO is null"));
//        }
    //数据接收成功，获取idCard，准备写入本地表

//        if (responseDTO.getErrCode()=="0"){
//      //      LOG.info(DataPoolLogUtil.toLog("Data acquisition success, access data"));
//    }
}

/**
 * 人员信息查询（带入住信息）
 * http://52.62.1.181:9020/LLGA/open/api/dataQuery?JobName=QUERY_PERSON_INFO2&idCard=522730197506162544
 */
//    @GetMapping("/open/api/dataQuery")
//    public void getall(@RequestParam(value = "JobName") String JobName,
//                       @RequestParam(value = "idCard") String idCard) {
//        MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>();
//        ResponseDTO<List<AllInfoBean>> responseDTO2 = new ResponseDTO<>();
//        RestTemplate restTemplate = new RestTemplate();
//        String surll = url + "?JobName={name}&idCard={idCard}";
//        System.out.println(surll);
//        paramMap.add("name", "QUERY_PERSON_INFO2");
//
//        paramMap.add("idCard", "522730197506162544");
//        //文档中标注的是post请求，但是发送的时候请求异常，本地发送get请求可以
//        System.out.println("surl:" + surll);
//        responseDTO2 = restTemplate.getForObject(surll, ResponseDTO.class, paramMap);
//        System.out.println(responseDTO2.toString());
//    }
//  }
