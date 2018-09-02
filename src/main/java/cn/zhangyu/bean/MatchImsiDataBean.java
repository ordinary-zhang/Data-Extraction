package cn.zhangyu.bean;

import java.io.Serializable;

/**
 * Created by grace on 2018/9/2.
 */
public class MatchImsiDataBean implements Serializable{

    private static final long serialVersionUID = -1251391033024143902L;

    private String match_count;

    private String phone_imsi;

    private String vehicle_plate;

    private String updatetime;

    private String phone_site;

    private String phone_count;

    public String getMatch_count() {
        return match_count;
    }

    public void setMatch_count(String match_count) {
        this.match_count = match_count;
    }

    public String getPhone_imsi() {
        return phone_imsi;
    }

    public void setPhone_imsi(String phone_imsi) {
        this.phone_imsi = phone_imsi;
    }

    public String getVehicle_plate() {
        return vehicle_plate;
    }

    public void setVehicle_plate(String vehicle_plate) {
        this.vehicle_plate = vehicle_plate;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getPhone_site() {
        return phone_site;
    }

    public void setPhone_site(String phone_site) {
        this.phone_site = phone_site;
    }

    public String getPhone_count() {
        return phone_count;
    }

    public void setPhone_count(String phone_count) {
        this.phone_count = phone_count;
    }
}
