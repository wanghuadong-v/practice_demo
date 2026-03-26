package test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Description TODO
 * @Author wanghuadong
 * @Date 2024/11/22 9:04
 */
public class test11 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now + "");


        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = now.format(df);
        System.out.println(format);
    }
}
