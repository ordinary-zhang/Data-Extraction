package cn.zhangyu.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;


public class RoomBean implements Serializable{

    private static final long serialVersionUID = 6801907805243561804L;

    @Id
    @GenericGenerator(name="idGenerator", strategy="uuid") //这个是hibernate的注解/生成32位UUID
    @GeneratedValue(generator="idGenerator")
    private String uuid;

    private String address;

    private String ownerIdCard;

    private String ownerMobile;

    private String ownerName;

    private List<HabitationBean> RoomDwellerInfo;

    private List<CarBean> carInfo;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOwnerIdCard() {
        return ownerIdCard;
    }

    public void setOwnerIdCard(String ownerIdCard) {
        this.ownerIdCard = ownerIdCard;
    }

    public String getOwnerMobile() {
        return ownerMobile;
    }

    public void setOwnerMobile(String ownerMobile) {
        this.ownerMobile = ownerMobile;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public List<HabitationBean> getRoomDwellerInfo() {
        return RoomDwellerInfo;
    }

    public void setRoomDwellerInfo(List<HabitationBean> roomDwellerInfo) {
        RoomDwellerInfo = roomDwellerInfo;
    }

    public List<CarBean> getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(List<CarBean> carInfo) {
        this.carInfo = carInfo;
    }
}
