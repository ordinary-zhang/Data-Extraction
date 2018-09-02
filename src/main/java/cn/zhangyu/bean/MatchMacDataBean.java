package cn.zhangyu.bean;

import java.io.Serializable;

/**
 * Created by grace on 2018/9/2.
 */
public class MatchMacDataBean implements Serializable {

    private static final long serialVersionUID = 2933299339022931879L;

    private String  matchCount;

    private String  phoneMac;

    private String phoneImsi;

    private String  updateTime;

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
}
