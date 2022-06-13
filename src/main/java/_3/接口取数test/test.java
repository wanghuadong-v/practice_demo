package _3.接口取数test;

/**
 * @Description TODO
 * @Author wanghuadong
 * @Date 2021/7/12 9:59
 */
public class test {
    public static void main(String[] args) {
        String token = TokenUtil.createToken();
        String data = TokenUtil.getData(token, "/mtapi/xxbw/yd/list");
        System.out.println(data);
    }
}
