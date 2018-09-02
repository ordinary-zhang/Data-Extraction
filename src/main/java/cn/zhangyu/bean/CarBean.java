package cn.zhangyu.bean;

import java.io.Serializable;

/**
 * Created by grace on 2018/9/2.
 */
public class CarBean implements Serializable{

    private static final long serialVersionUID = 8216341018312774532L;

    private String carColor;

    private String carModel;

    private String carNanufacturer;

    private String carNumber;

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarNanufacturer() {
        return carNanufacturer;
    }

    public void setCarNanufacturer(String carNanufacturer) {
        this.carNanufacturer = carNanufacturer;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }
}
