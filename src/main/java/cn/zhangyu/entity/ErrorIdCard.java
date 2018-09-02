package cn.zhangyu.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by grace on 2018/9/2.
 */
public class ErrorIdCard implements Serializable{

    private static final long serialVersionUID = 7375618930282609458L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String idCard;

    private Date StorageTime;

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Date getStorageTime() {
        return StorageTime;
    }

    public void setStorageTime(Date storageTime) {
        StorageTime = storageTime;
    }
}
