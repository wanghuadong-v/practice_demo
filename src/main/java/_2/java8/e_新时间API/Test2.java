package _2.java8.e_新时间API;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjusters;

/**
 * @Author: wanghuadong
 * @Date: 2020/12/23 20:32
 * @Version: 1.0
 */
public class Test2 {
    /**
     *TemporalAdjuster :时间校正器
     */
    @Test
    public void test1(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime localDateTime = now.withDayOfMonth(10);
        System.out.println(localDateTime);

        //获取下一个周日日期
        LocalDateTime with = now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(with);
    }

    /**
     * DateTimeFirmatter  :时间/日期格式化
     */
    @Test
    public void test2(){
        DateTimeFormatter isoDateTime = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime now = LocalDateTime.now();
        String format = isoDateTime.format(now);
        System.out.println(format);

        System.out.println("---------------------------------------------------------");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String format1 = dateTimeFormatter.format(now);
        System.out.println(format1);

        System.out.println("----------------------------------");
        LocalDateTime parse = now.parse("1996年03月05日 12:12:12", dateTimeFormatter);
        System.out.println(parse);
    }
}
