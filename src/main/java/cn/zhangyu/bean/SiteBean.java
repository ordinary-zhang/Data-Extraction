package cn.zhangyu.bean;

import java.io.Serializable;

/**
 * Created by grace on 2018/9/2.
 */
public class SiteBean implements Serializable{

    private static final long serialVersionUID = -2180416036949270134L;

    private String siteId;

    private String siteName;

    private String cityName;

    private String hasPLATE;

    private String hasRDCJ;

    private String latitude;

    private String longitude;

    private String crossing_indexcode;

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getHasPLATE() {
        return hasPLATE;
    }

    public void setHasPLATE(String hasPLATE) {
        this.hasPLATE = hasPLATE;
    }

    public String getHasRDCJ() {
        return hasRDCJ;
    }

    public void setHasRDCJ(String hasRDCJ) {
        this.hasRDCJ = hasRDCJ;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getCrossing_indexcode() {
        return crossing_indexcode;
    }

    public void setCrossing_indexcode(String crossing_indexcode) {
        this.crossing_indexcode = crossing_indexcode;
    }
}
