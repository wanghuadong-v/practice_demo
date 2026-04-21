package test;

import java.time.LocalDate;

public class Test26 {
    public static void main(String[] args) throws InterruptedException {
        LocalDate now1 = LocalDate.now();

        Thread.sleep(1000);

        LocalDate now2 = LocalDate.now();

        boolean after = now2.isAfter(now1);
        System.out.printf(String.valueOf(after));
    }
}
