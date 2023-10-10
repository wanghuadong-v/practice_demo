package test;

/**
 * @Description TODO
 * @Author wanghuadong
 * @Date 2022/7/28 15:57
 */
public class 计算测试 {
    public static void main(String[] args) {


        double pow = Math.pow(5 / 0.8314, 1.0545);
        double v = 0.1180 + ((1.0252 - 0.1180) / (1 + pow));

        System.out.println(pow);
        System.out.println(v);

    }
}
