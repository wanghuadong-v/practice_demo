package test;

import com.googlecode.aviator.AviatorEvaluator;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author wanghuadong
 * @Date 2025/1/8 17:52
 */
public class test12 {
    public static void main(String[] args) {
        String expression = "c == 0 ? 0 : a / c";

        Map<String, Object> env = new HashMap<>();
        env.put("c", 0);
        env.put("a", 6);
//        env.put("c", 10);
        Long execute = (Long)AviatorEvaluator.execute(expression, env);
        System.out.println(execute);
    }
}
