package test;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Description TODO
 * @Author wanghuadong
 * @Date 2025/4/15 9:55
 */
public class test14 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Float.MAX_VALUE);

        Integer a = 127;
        Integer b = 127;

        Integer c = 128;
        Integer d = 128;

        System.out.println(a == b);
        System.out.println(c == d);

        LocalDateTime now = LocalDateTime.now();
        LocalDate today = now.toLocalDate();
        LocalDateTime localDateTime = today.atStartOfDay();
        System.out.println(localDateTime);
        LocalDate localDate = today.plusDays(1);
        System.out.println(localDate.atStartOfDay());
        LocalDate localDate1 = today.plusDays(2);
        System.out.println(localDate1.atStartOfDay());
        System.out.println(localDateTime);

    }
}
