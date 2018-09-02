package cn.zhangyu.controller;

import cn.zhangyu.DTO.ZResponseDTO;
import cn.zhangyu.bean.ImsiBean;
import cn.zhangyu.bean.MatchImsiDataBean;
import cn.zhangyu.bean.MatchMacDataBean;
import cn.zhangyu.bean.SiteBean;
import cn.zhangyu.entity.ImsiEntity;
import cn.zhangyu.entity.MatchImsiDataEntity;
import cn.zhangyu.entity.MatchMacDataEntiry;
import cn.zhangyu.entity.SiteEntity;
import cn.zhangyu.repository.ImsiRepository;
import cn.zhangyu.repository.MatchImsiDataRepository;
import cn.zhangyu.repository.MatchMacDataRepository;
import cn.zhangyu.repository.SiteRepository;
import cn.zhangyu.util.TimeUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.*;

/**
     * 车辆轨迹，站点查询
     */
    @RestController
    @RequestMapping(value = "/trail")
public class TrailController {

        private static final Logger LOG = LoggerFactory.getLogger(TrailController.class);

        @Autowired
        private SiteRepository siteRepository;

        @Autowired
        private ImsiRepository imsiRepository;

        @Autowired
        private MatchImsiDataRepository matchImsiDataRepository;

        @Autowired
        private MatchMacDataRepository matchMacDataRepository;

        @Value("${zUrl}")
        private String url;

        @Value("${loginUrl}")
        private String loginUrl;

        @Value("${username}")
        private String username;

        @Value("${password}")
        private String password;

        private RestTemplate restTemplate = new RestTemplate();
        /**
         * 站点查询  (测试post get都可以)
         */
        @RequestMapping(value = "/site", method = RequestMethod.GET)
        public void getSite() {
            String cookie = login();
            System.out.println("cookie:"+cookie);
            String siteUrl = url + "/sites/data";
            System.out.println("siteUrl: "+siteUrl);
            if (cookie != null) {
                HttpPost post = new HttpPost(siteUrl);
                post.setHeader("Content-Type", "application/json");
                post.setHeader("Cookie", cookie);
                CloseableHttpClient hc = HttpClientBuilder.create().build();
                HttpResponse resp = null;
                ZResponseDTO<List<SiteBean>> siteBeanResponseDTO = new ZResponseDTO<>();
                try {
                    resp = hc.execute(post);
                    String result = EntityUtils.toString(resp.getEntity());
                    //System.out.println("----------------------------------------------");
                    //System.out.println("result===" + result);
                    // System.out.println("----------------------------------------------");
                    siteBeanResponseDTO = JSONObject.parseObject(result, ZResponseDTO.class);
                    List<SiteBean> siteBeans = JSONObject.parseArray(JSONObject.toJSONString(siteBeanResponseDTO.getData()), SiteBean.class);
                    if (siteBeans!=null){
                        siteBeans.forEach(siteBean -> {
                            LOG.info("获取数据存入数据库");
                            SiteEntity siteEntity = new SiteEntity();
                            siteEntity.setSiteId(siteBean.getSiteId());
                            siteEntity.setSiteName(siteBean.getSiteName());
                            siteEntity.setCityName(siteBean.getCityName());
                            siteEntity.setHasPLATE(siteBean.getHasPLATE());
                            siteEntity.setHasRDCJ(siteBean.getHasRDCJ());
                            siteEntity.setLatitude(siteBean.getLatitude());
                            siteEntity.setLongitude(siteBean.getLongitude());
                            siteEntity.setCrossingIndexcode(siteBean.getCrossing_indexcode());
                            siteEntity.setStorageTime(new Date());
                            siteRepository.save(siteEntity);
                            LOG.info("数据成功存入数据库");
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


//    @RequestMapping(value = "/site", method = RequestMethod.GET)
//    public void getSite() throws IOException {
//        //登录,返回respose信息
//        String cookie=login2();
//        //login4();
//        //登陆成功请求站点数据(post请求)
//        //http://${ip}:${port}/datamanager/service/api/sites/data 没有参数
//        String siteUrl = url + "/sites/data";
//        System.out.println("siteurl::" + siteUrl);
//        ZResponseDTO<List<SiteBean>> siteBeanResponseDTO = new ZResponseDTO();
//        //发送请求
//        LOG.info("登陆成功请求站点数据");
//        //header中添加cookie
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Cookie", cookie);
//        //HttpEntity
//        HttpEntity<HttpHeaders> requestEntity = new HttpEntity<HttpHeaders>(headers);
//        //siteBeanResponseDTO=restTemplate.getForObject(siteUrl,ZResponseDTO.class);
//        siteBeanResponseDTO = restTemplate.postForObject(siteUrl, requestEntity, ZResponseDTO.class);
//        //获取所有站点信息
//        List<SiteBean> siteBeans = JSONObject.parseArray(JSONObject.toJSONString(siteBeanResponseDTO.getData()), SiteBean.class);
//        //数据存入数据库
//        siteBeans.forEach(siteBean -> {
//            LOG.info("获取数据存入数据库");
//            SiteEntity siteEntity = new SiteEntity();
//            siteEntity.setSiteId(siteBean.getSiteId());
//            siteEntity.setSiteName(siteBean.getSiteName());
//            siteEntity.setCityName(siteBean.getCityName());
//            siteEntity.setHasPLATE(siteBean.getHasPLATE());
//            siteEntity.setHasRDCJ(siteBean.getHasRDCJ());
//            siteEntity.setLatitude(siteBean.getLatitude());
//            siteEntity.setLongitude(siteBean.getLongitude());
//            siteEntity.setCrossingIndexcode(siteBean.getCrossing_indexcode());
//            siteEntity.setStorageTime(new Date());
//            siteRepository.save(siteEntity);
//            LOG.info("数据成功存入数据库");
//        });
//    }


        /**
         * 数据查询
         * 开始时间，结束时间以15分钟为最大间隔，大于15分钟的查询返回失败；外部系统一般延迟 1，2分钟查询当前的数据，保证数据完整性。
         */
        @RequestMapping(value = "/imsi", method = RequestMethod.POST)
        //@Scheduled(fixedRate = 900000) //每隔十五分钟执行一次
        @Scheduled(fixedDelay = 180000) //定时器将在延迟3分钟后每隔3分钟执行
        public void getImsi(){
            //登录
            String cookie = login();
            //登录成功查询数据
            String dataUrl = url + "/imsi/data";
            System.out.println("dataUrl:"+dataUrl);

            //body   body中传递的参数为json格式
            //MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
            LOG.info("登录成功查询数据");
            List<String> list = new ArrayList<>();
            //站点查询
            List<SiteEntity> all = siteRepository.findAll();
            all.forEach(item -> {
                list.add(item.getSiteId());
            });
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("starttime", TimeUtil.getStartTime());
            jsonObj.put("stoptime", TimeUtil.getStopTime());
            jsonObj.put("sites", list);
            ZResponseDTO<List<ImsiBean>> imsiBeanResponseDTO = new ZResponseDTO<>();
            //header中添加cookie
            if (cookie != null) {
                HttpPost post = new HttpPost(dataUrl);
                StringEntity requestEntity = new StringEntity(jsonObj.toJSONString(),"utf-8");
                post.setHeader("Content-Type", "application/json");
                post.setHeader("Cookie", cookie);
                post.setEntity(requestEntity);
                CloseableHttpClient hc = HttpClientBuilder.create().build();
                HttpResponse resp = null;
                try {
                    resp = hc.execute(post);
                    String result = EntityUtils.toString(resp.getEntity());
                    //System.out.println("----------------------------------------------");
                    System.out.println("result===" + result);
                    imsiBeanResponseDTO = JSONObject.parseObject(result, ZResponseDTO.class);
                    List<ImsiBean> imsiBeans = JSONObject.parseArray(JSONObject.toJSONString(imsiBeanResponseDTO.getData()), ImsiBean.class);
                    if (imsiBeans!=null){
                        imsiBeans.forEach(imsiBean -> {
                            LOG.info("获取数据存入数据库");
                            ImsiEntity imsiEntity = new ImsiEntity();
                            imsiEntity.setCollectTime(imsiBean.getCollectTime());
                            imsiEntity.setImei(imsiBean.getImei());
                            imsiEntity.setImsi(imsiBean.getImsi());
                            imsiEntity.setLocation(imsiBean.getLocation());
                            imsiEntity.setMsuplev(imsiBean.getMsuplev());
                            imsiEntity.setOperator(imsiBean.getOperator());
                            imsiEntity.setPhone(imsiBean.getPhone());
                            imsiEntity.setSite(imsiBean.getSite());
                            imsiEntity.setStorageTime(new Date());
                            imsiEntity.setAgent(imsiBean.getAgent());
                            //System.out.println(imsiBean.getAgent()+imsiBean.getSite_id()+imsiBean.getSeq());
                            imsiEntity.setSite_id(imsiBean.getSite_id());
                            imsiEntity.setSeq(imsiBean.getSeq());
                            imsiRepository.save(imsiEntity);
                            LOG.info("数据成功存入数据库");
                        });
                    }
                } catch (Exception e) {
                    System.out.println(new Date() + ":数据查询失败");
                    e.printStackTrace();
                }
            }
        }

        /**
         * imsi匹配数据查询  type=1
         * 因为此数据为计算出来的结果；所以一般每次查询一天的数据，每天查询一次。
         */
        @RequestMapping(value = "/getMatchImsiData")
        //@Scheduled(cron = "0 0 2 * * ?") //每天的凌晨两点执行
        @Scheduled(fixedRate = 300000) //每隔五分钟执行一次
        public void getMatchImsiData() throws IOException {
            //先进行登录验证
            String cookie=login();
            LOG.info("登录成功查询ImsiData");
            //登录成功查询数据
            String matchUrl = url + "/matchdata";
            //header中添加cookie
            //body
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("type", 1);
            jsonObj.put("starttime", TimeUtil.getDayStartTime());
            jsonObj.put("stoptime", TimeUtil.getDayStopTime());
            ZResponseDTO<List<MatchImsiDataBean>> matchImsiDataBeanDTO = new ZResponseDTO<>();
            if (cookie != null) {
                HttpPost post = new HttpPost(matchUrl);
                StringEntity requestEntity = new StringEntity(jsonObj.toJSONString(), "utf-8");
                post.setHeader("Content-Type", "application/json");
                post.setHeader("Cookie", cookie);
                post.setEntity(requestEntity);
                CloseableHttpClient hc = HttpClientBuilder.create().build();
                HttpResponse resp = null;
                try {
                    resp = hc.execute(post);
                    String result = EntityUtils.toString(resp.getEntity());
                    //System.out.println("----------------------------------------------");
                    //System.out.println("result===" + result);
                    matchImsiDataBeanDTO = JSONObject.parseObject(result, ZResponseDTO.class);
                    List<MatchImsiDataBean> matchImsiDataBeans = JSONObject.parseArray(JSONObject.toJSONString(matchImsiDataBeanDTO.getData()), MatchImsiDataBean.class);
                    if (matchImsiDataBeans!=null){
                        matchImsiDataBeans.forEach(matchImsiDataBean -> {
                            LOG.info("获取数据存入数据库");
                            MatchImsiDataEntity matchDataEntity = new MatchImsiDataEntity();
                            matchDataEntity.setMatchCount(matchImsiDataBean.getMatch_count());
                            matchDataEntity.setPhoneImsi(matchImsiDataBean.getPhone_imsi());
                            matchDataEntity.setVehiclePlate(matchImsiDataBean.getVehicle_plate());
                            matchDataEntity.setUpdateTime(matchImsiDataBean.getUpdatetime());
                            matchDataEntity.setPhoneSite(matchImsiDataBean.getPhone_site());
                            matchDataEntity.setPhoneCount(matchImsiDataBean.getPhone_count());
                            matchDataEntity.setStorageTime(new Date());
                            matchImsiDataRepository.save(matchDataEntity);
                            LOG.info("数据成功存入数据库");
                        });
                    }
                } catch (Exception e) {
                    System.out.println("Imsi匹配车牌数据查询失败");
                    LOG.error(e.getMessage());
                    e.printStackTrace();
                }
            }
        }

        /**
         * mac匹配数据查询  type=2
         * 因为此数据为计算出来的结果；所以一般每次查询一天的数据，每天查询一次。
         */
        @RequestMapping(value = "/getMatchMacData")
        //@Scheduled(cron = "0 0 3 * * ?") //每天的凌晨三点执行
        @Scheduled(fixedRate = 300000) //每隔五分钟执行一次
        public void getMatchMacData() throws IOException {
            //先进行登录验证
            String cookie=login();
            LOG.info("登录成功查询MacData");
            //登录成功查询数据
            String matchUrl = url + "/matchdata";

            //header中添加cookie
            //HttpHeaders headers = new HttpHeaders();
            //headers.add("Cookie", cookie);
            //body
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("type", 2);
            jsonObj.put("starttime", TimeUtil.getDayStartTime());
            jsonObj.put("stoptime", TimeUtil.getDayStopTime());
            ZResponseDTO<List<MatchMacDataBean>> matchMacDataBeanDTO = new ZResponseDTO<>();
            if (cookie != null) {
                HttpPost post = new HttpPost(matchUrl);
                StringEntity requestEntity = new StringEntity(jsonObj.toJSONString(), "utf-8");
                post.setHeader("Content-Type", "application/json");
                post.setHeader("Cookie", cookie);
                post.setEntity(requestEntity);
                CloseableHttpClient hc = HttpClientBuilder.create().build();
                HttpResponse resp = null;
                try {
                    resp = hc.execute(post);
                    String result = EntityUtils.toString(resp.getEntity());
                    //System.out.println("----------------------------------------------");
                    //System.out.println("result===" + result);
                    matchMacDataBeanDTO = JSONObject.parseObject(result, ZResponseDTO.class);
                    List<MatchMacDataBean> matchMacDataBeans = JSONObject.parseArray(JSONObject.toJSONString(matchMacDataBeanDTO.getData()), MatchMacDataBean.class);

                    matchMacDataBeans.forEach(matchMacDataBean -> {
                        LOG.info("获取数据存入数据库");
                        MatchMacDataEntiry matchDataEntity = new MatchMacDataEntiry();
                        matchDataEntity.setMatchCount(matchMacDataBean.getMatchCount());
                        matchDataEntity.setPhoneMac(matchMacDataBean.getPhoneMac());
                        matchDataEntity.setPhoneImsi(matchMacDataBean.getPhoneImsi());
                        matchDataEntity.setUpdateTime(matchMacDataBean.getUpdateTime());
                        matchDataEntity.setStorageTime(new Date());
                        matchMacDataRepository.save(matchDataEntity);
                        LOG.info("数据成功存入数据库");
                    });
                } catch (Exception e) {
                    System.out.println("Imsi匹配车牌数据查询失败");
                    LOG.error(e.getMessage());
                    e.printStackTrace();
                }
            }
        }

        public static String login() {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpResponse response = null;
            String cookie = null;
            String sURL="http://52.62.0.249:9080/datamanager/newLogin";
            try {
                HttpGet getLogin = new HttpGet(sURL);
                response = httpClient.execute(getLogin);
                InputStream input = response.getEntity().getContent();
                BufferedReader br = new BufferedReader(new InputStreamReader(input));
                String htmlLine = null;
                String value = null;
                //每次读一行
                while ((htmlLine = br.readLine()) != null) {
                    if(htmlLine.contains("name=\"_csrf\" value")){//找到csrf对应的行
                        int startIndex = htmlLine.indexOf("value=\"");
                        int endIndex = htmlLine.indexOf("\"/>");
                        value = htmlLine.substring(startIndex + "value=\"".length(), endIndex);//把csrf的value取出来
                        System.out.println(value);
                        break;
                    }
                }
                HttpPost httpPost = new HttpPost(sURL);
                httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("username", "test"));
                params.add(new BasicNameValuePair("password", "test"));

                if(value != null)//如果有csrf 需要将csrf设置到 参数
                    params.add(new BasicNameValuePair("_csrf", value));

                httpPost.setEntity(new UrlEncodedFormEntity(params));

                HttpContext context = new BasicHttpContext();

                response = httpClient.execute(httpPost, context);
                Header firstHeader = response.getFirstHeader("Set-Cookie");
                System.out.println(response.getStatusLine().toString());

                System.out.println("context:" + context.toString());
//            Header[] hds =  response.getHeaders("Location");
//            for(Header hd : hds){
//                System.out.println(hd.getName() + " ==> " + hd.getValue());
//            }

//            Header[] headers = response.getAllHeaders();
//            for (Header hd : headers) {
//                System.out.println(hd);
//            }

                String s = String.valueOf(firstHeader);
                String subString = s.substring(s.indexOf("J"), s.indexOf(";"));//截取 sessionid
                System.out.println("subString:" + subString);
                cookie = subString;
                InputStream input2 = response.getEntity().getContent();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            return cookie;
        }
}
