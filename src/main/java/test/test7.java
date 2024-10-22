package test;

import java.util.Calendar;
import java.util.Date;

/**
 * @Description TODO
 * @Author wanghuadong
 * @Date 2024/9/2 10:30
 */
public class test7 {
    public static void main(String[] args) {
        Date date = new Date();
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(Calendar.MINUTE,10);
        Date time = instance.getTime();
        System.out.println(date);
        System.out.println(time);
    }
}
