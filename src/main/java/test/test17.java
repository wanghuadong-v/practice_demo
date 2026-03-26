package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.Executors;

/**
 * @Description TODO
 * @Author wanghuadong
 * @Date 2025/6/11 21:19
 */
public class test17 {
    public static void main(String[] args) {
        // 获取当前日期
        LocalDate today = LocalDate.now();
        // 计算昨天的日期
        LocalDate yesterday = today.minusDays(1);
        // 得到昨天零点的 LocalDateTime
        LocalDateTime yesterdayMidnight = LocalDateTime.of(yesterday, LocalTime.MIDNIGHT);
        System.out.println(yesterdayMidnight);
    }
}
