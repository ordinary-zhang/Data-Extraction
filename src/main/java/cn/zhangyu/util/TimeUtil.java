package cn.zhangyu.util;

import org.apache.commons.lang.time.FastDateFormat;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by grace on 2018/9/2.
 */
public class TimeUtil {
    //SimpleDateFormat非线程安全  使用FastDateFormat代替

    private static FastDateFormat sd=FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");

    private static Calendar calendar = Calendar.getInstance();


    /**
     * SimpleDateFormat.format的作用是将Date值转换成格式化的字符串。
     * SimpleDateFormat.parse的作用是将格式化的字符串转换成Date值。
     * 一定要注意parse和format的区别，尤其是参数类型和返回类型。
     * @return
     */
    public static String getStartTime(){
        Date date=new Date();//获得系统当前的时间
//      long date=(long)24979599*60000;    //任意毫秒数，可以parse转化为日期类型后getTime获取
//      long date=1498838705129l;
        //System.out.println("系统目前时间："+date);
        //String form=sd.format(date);
        //设置当前日期
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE,-3);
        //System.out.println("目前时间："+form);
        //System.out.println("延迟两分钟：" +      sd.format(calendar.getTime()));
        return sd.format(calendar.getTime());
    }

    public static String getStopTime(){
        Date date=new Date();//获得系统当前的时间
        //设置当前日期
        //calendar.setTime(date);
        String form=sd.format(date);
        //设置当前日期
        //calendar.setTime(date);
        //calendar.add(Calendar.MINUTE,5);
        //System.out.println("目前时间："+form);
        //System.out.println("十五分钟后的时间：" +      sd.format(calendar.getTime()));
        return form;
    }

    public static String getDayStartTime(){
        Date date=new Date();//获得系统当前的时间
        //设置当前日期
        calendar.setTime(date);
        //24小时制
        //System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
        calendar.add(Calendar.DAY_OF_WEEK,-1);
        String form=sd.format(date);
        // System.out.println("目前时间："+form);
        //System.out.println("延迟一天的时间：" +      sd.format(calendar.getTime()));
        return sd.format(calendar.getTime());
    }

    public static String getDayStopTime(){
        Date date=new Date();//获得系统当前的时间
        String form=sd.format(date);
        return form;
    }
}
