package cn.zhangyu.bean;

import java.io.Serializable;

/**
 * Created by grace on 2018/9/2.
 */
public class ImsiBean implements Serializable{

    private static final long serialVersionUID = 1093704489080229008L;

    private String collectTime;

    private String imei;

    private String imsi;

    private String location;

    private String msuplev;

    private String operator;

    private String phone;

    private String site;

    private String site_id;

    private String seq;

    private String agent;

    public String getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(String collectTime) {
        this.collectTime = collectTime;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMsuplev() {
        return msuplev;
    }

    public void setMsuplev(String msuplev) {
        this.msuplev = msuplev;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getSite_id() {
        return site_id;
    }

    public void setSite_id(String site_id) {
        this.site_id = site_id;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }
}
