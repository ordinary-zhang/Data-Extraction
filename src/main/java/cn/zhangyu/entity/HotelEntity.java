package cn.zhangyu.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by grace on 2018/9/2.
 */
public class HotelEntity implements Serializable{

    private static final long serialVersionUID = 1073701636005495333L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String checkIndate;

    private String checkOutdate;

    private String hotelName;

    private String idCard;

    private String name;

    private String roomNum;

    private Date storageTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCheckIndate() {
        return checkIndate;
    }

    public void setCheckIndate(String checkIndate) {
        this.checkIndate = checkIndate;
    }

    public String getCheckOutdate() {
        return checkOutdate;
    }

    public void setCheckOutdate(String checkOutdate) {
        this.checkOutdate = checkOutdate;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public Date getStorageTime() {
        return storageTime;
    }

    public void setStorageTime(Date storageTime) {
        this.storageTime = storageTime;
    }
}
