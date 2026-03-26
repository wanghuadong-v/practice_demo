package test;


/**
 * @Description TODO
 * @Author wanghuadong
 * @Date 2024/10/29 13:44
 */
public class test10 {
    public static void main(String[] args) {
        Double aa = 1D;
        Double bb = 34.2D;
        int i = aa.compareTo(bb);
        int i1 = bb.compareTo(aa);
        System.out.println(i);
        System.out.println(i1);

        Double cc = 1.1D;
        Double dd = 1.100D;
        int i2 = cc.compareTo(dd);
        System.out.println(i2);
    }
}
