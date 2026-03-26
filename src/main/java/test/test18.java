package test;

import java.time.LocalDateTime;

/**
 * @Description TODO
 * @Author wanghuadong
 * @Date 2025/12/19 10:50
 */
public class test18 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        System.out.println(now);

        LocalDateTime localDateTime = now.plusDays(1);

        System.out.println(now);
        System.out.println(localDateTime);
    }
}
