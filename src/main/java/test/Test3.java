package test;

import java.time.LocalDate;
import java.time.YearMonth;

/**
 * @Description TODO
 * @Author wanghuadong
 * @Date 2023/10/10 10:16
 */
public class Test3 {
    public static void main(String[] args) {
        // 获取当前日期
        LocalDate currentDate = LocalDate.now();

        // 获取当前年月
        YearMonth currentYearMonth = YearMonth.from(currentDate);

        // 打印当前年月
        System.out.println("当前年月: " + currentYearMonth);
    }
}
