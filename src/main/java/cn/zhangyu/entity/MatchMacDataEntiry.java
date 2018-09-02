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
public class MatchMacDataEntiry implements Serializable{

    private static final long serialVersionUID = -6283571559685321385L;
    //自增id
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String  matchCount;

    private String  phoneMac;

    private String phoneImsi;

    private String  updateTime;

    private Date storageTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatchCount() {
        return matchCount;
    }

    public void setMatchCount(String matchCount) {
        this.matchCount = matchCount;
    }

    public String getPhoneMac() {
        return phoneMac;
    }

    public void setPhoneMac(String phoneMac) {
        this.phoneMac = phoneMac;
    }

    public String getPhoneImsi() {
        return phoneImsi;
    }

    public void setPhoneImsi(String phoneImsi) {
        this.phoneImsi = phoneImsi;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Date getStorageTime() {
        return storageTime;
    }

    public void setStorageTime(Date storageTime) {
        this.storageTime = storageTime;
    }
}
