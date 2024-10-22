package test;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Description TODO
 * @Author wanghuadong
 * @Date 2024/7/9 18:32
 */
public class Test4 {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDate.now().atStartOfDay();
        System.out.println(localDateTime);
    }
}
