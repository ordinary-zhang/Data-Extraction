package cn.zhangyu.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by grace on 2018/9/2.
 */
public class AllInfoBean implements Serializable{

    private static final long serialVersionUID = 6542688464588824014L;

    private String lng;

    private String lat;

    private String imgUrl;

    private String imgPath;

    private String ownerMobile;

    private String isKeyPerson;

    private String nation;

    private String idCard;

    private String sex;

    private String keyType;

    private String name;

    private String birthDate;

    private String cardAddr;

    private RoomBean roomInfo;

    private List<HotelBean> hotelInfo;

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getOwnerMobile() {
        return ownerMobile;
    }

    public void setOwnerMobile(String ownerMobile) {
        this.ownerMobile = ownerMobile;
    }

    public String getIsKeyPerson() {
        return isKeyPerson;
    }

    public void setIsKeyPerson(String isKeyPerson) {
        this.isKeyPerson = isKeyPerson;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getKeyType() {
        return keyType;
    }

    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getCardAddr() {
        return cardAddr;
    }

    public void setCardAddr(String cardAddr) {
        this.cardAddr = cardAddr;
    }

    public RoomBean getRoomInfo() {
        return roomInfo;
    }

    public void setRoomInfo(RoomBean roomInfo) {
        this.roomInfo = roomInfo;
    }

    public List<HotelBean> getHotelInfo() {
        return hotelInfo;
    }

    public void setHotelInfo(List<HotelBean> hotelInfo) {
        this.hotelInfo = hotelInfo;
    }
}

