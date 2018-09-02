package cn.zhangyu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by grace on 2018/9/2.
 */

@Entity
public class MatchImsiDataEntity implements Serializable {

    private static final long serialVersionUID = -6160597936909402460L;

    //自增id
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String matchCount;

    private String phoneImsi;

    private String vehiclePlate;

    private String updateTime;

    private String phoneSite;

    private String phoneCount;

    private Date storageTime;

    public MatchImsiDataEntity() {
    }

    public String getMatchCount() {
        return matchCount;
    }

    public void setMatchCount(String matchCount) {
        this.matchCount = matchCount;
    }

    public String getPhoneImsi() {
        return phoneImsi;
    }

    public void setPhoneImsi(String phoneImsi) {
        this.phoneImsi = phoneImsi;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getPhoneSite() {
        return phoneSite;
    }

    public void setPhoneSite(String phoneSite) {
        this.phoneSite = phoneSite;
    }

    public String getPhoneCount() {
        return phoneCount;
    }

    public void setPhoneCount(String phoneCount) {
        this.phoneCount = phoneCount;
    }

    public Date getStorageTime() {
        return storageTime;
    }

    public void setStorageTime(Date storageTime) {
        this.storageTime = storageTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
