package cn.zhangyu.entity;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by grace on 2018/9/2.
 */
@Entity
public class SiteEntity implements Serializable{

    private static final long serialVersionUID = -3464013640013679636L;

    private String siteId;

    private String siteName;

    private String cityName;

    private String hasPLATE;

    private String hasRDCJ;

    private String latitude;

    private String longitude;

    private String crossingIndexcode;

    private Date storageTime;

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

    public String getCrossingIndexcode() {
        return crossingIndexcode;
    }

    public void setCrossingIndexcode(String crossingIndexcode) {
        this.crossingIndexcode = crossingIndexcode;
    }

    public Date getStorageTime() {
        return storageTime;
    }

    public void setStorageTime(Date storageTime) {
        this.storageTime = storageTime;
    }
}
