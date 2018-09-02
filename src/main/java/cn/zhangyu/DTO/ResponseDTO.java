package cn.zhangyu.DTO;

import cn.zhangyu.code.ResponseCodeEnum;

import java.io.Serializable;

/**
 * Created by grace on 2018/9/2.
 */
public class ResponseDTO<T> implements Serializable {
    private String errCode;

    private String errMsg;

    private T data;

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setResult(String errCode, String errMsg, T data) {
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.data = data;
    }

    public void setResult (String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public void setResult (ResponseCodeEnum codeEnum) {
        this.errCode = codeEnum.getCode();
        this.errMsg = codeEnum.getMessage();
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "errCode='" + errCode + '\'' +
                ", errMsg='" + errMsg + '\'' +
                ", data=" + data +
                '}';
    }
}
