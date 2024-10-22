package test;

/**
 * @Description TODO
 * @Author wanghuadong
 * @Date 2024/7/15 21:41
 */
public class test5 {
    public static void main(String[] args) {
        test5 test5 = new test5();
        Class<Test3> test3Class = Test3.class;
        test5.test1(Test3.class);

    }
    public <E> void test1(Class<E> e){
        System.out.println(e);
    }
}
