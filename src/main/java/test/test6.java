package test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @Description TODO
 * @Author wanghuadong
 * @Date 2024/8/9 9:07
 */
public class test6 {
    public static void main(String[] args) {
        DecimalFormat decimalFormat = new DecimalFormat("0.###E0");
        BigDecimal bigDecimal = new BigDecimal("-999.0000000000");
        int i = new BigDecimal("-9996").compareTo(bigDecimal);
        System.out.println(i);

        BigDecimal qqq = new BigDecimal("0.000046");
        System.out.println(decimalFormat.format(qqq));


        BigDecimal bigDecimal1 = qqq.setScale(6, RoundingMode.HALF_UP).stripTrailingZeros();
        System.out.println(bigDecimal1);

        Integer aa = 1;
        System.out.println(aa.equals(1));
    }
}
