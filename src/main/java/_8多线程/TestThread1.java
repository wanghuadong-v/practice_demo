package _8多线程;

/**
 * @Description TODO
 * @Author wanghuadong
 * @Date 2024/6/25 14:07
 */
public class TestThread1 extends Thread{

    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println("重写run方法" + 1);

        }
    }

    public static void main(String[] args) {
        TestThread1 testThread1 = new TestThread1();
        testThread1.start();

        for (int i = 0; i < 200; i++) {
            System.out.println("main方法" + i);

        }
    }
}
