package test;

import javax.xml.transform.Source;
import java.util.HashMap;

/**
 * @Description TODO
 * @Author wanghuadong
 * @Date 2024/10/25 9:37
 */
public class test9 {
    public static void main(String[] args) {
        HashMap<Object, Object> map = null;
        try {
            Object aa = map.get("aa");
            System.out.println(aa);
        }catch (Exception e){
            System.out.println(e.toString());
            System.out.println(e.getMessage());
        }
    }
}
