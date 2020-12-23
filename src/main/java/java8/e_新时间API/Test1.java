package java8.e_新时间API;

import org.junit.Test;

import javax.xml.transform.Source;
import java.time.*;

/**
 * @Author: wanghuadong
 * @Date: 2020/12/22 21:57
 * @Version: 1.0
 */
public class Test1 {
    /**
     * 1.LocalDate  LocalTime LocalDateTime
     */
    @Test
    public void test1(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime localDateTime = now.plusYears(2);
        System.out.println(localDateTime);

        LocalDateTime of = LocalDateTime.of(1996, 03, 05, 13, 22, 33);
        System.out.println(of);

    }

    /**
     * Instant:时间戳  unix元年：19701月1日00:00:00
     */
    @Test
    public void test2(){
        Instant now = Instant.now();
        System.out.println(now);
        System.out.println(now.toEpochMilli());

        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

    }
    /**
     * Duration:计算两个“时间”之间的间隔
     */
    @Test
    public void test3(){
        Instant now = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant now1 = Instant.now();
        Duration between = Duration.between(now, now1);
        System.out.println(between.toMillis());
    }
    /**
     *    * period:计算两个”日期“之间的间隔
     */
    @Test
    public void test4(){
        LocalDate l1 = LocalDate.of(1996, 03, 05);
        LocalDate l2 = LocalDate.now();
        Period between = Period.between(l1, l2);
        System.out.println(between.getYears());
    }
}
