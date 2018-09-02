package cn.zhangyu.code;

/**
 * Created by grace on 2018/9/2.
 */
public enum  ResponseCodeEnum {
    CODE_ENUM, MESSAGE_ENUM;

    private static String code;
    private static String message;

    public static ResponseCodeEnum getInstance() {
        return CODE_ENUM;
    }

    ResponseCodeEnum() {
    }


    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
