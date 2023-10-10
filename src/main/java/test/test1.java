package test;

import java.util.UUID;
import java.util.regex.Pattern;

/**
 * @Description TODO
 * @Author wanghuadong
 * @Date 2021/6/18 9:35
 */
public class test1 {
    public static void main(String[] args) {

        UUID uuid = UUID.randomUUID();
//        System.out.println(uuid);


        String str = "2022-02-12";
        String substring = str.substring(0, 7);
//        System.out.println(substring);


        String str1 = "V2.0";
        String pattern = "^V[1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*$";
        boolean matches = Pattern.matches(pattern, str1);
        System.out.println(matches);

        String s = String.valueOf(null);
        System.out.println(s);

    }
}
