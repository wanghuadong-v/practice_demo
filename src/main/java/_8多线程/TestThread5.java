package _8多线程;

import java.util.concurrent.CompletableFuture;

/**
 * 控制多个线程的执行顺序
 */
public class TestThread5 {
    public static void main(String[] args) throws InterruptedException {
//        test1();
        test2();
    }

    public static void test1() throws InterruptedException {
        Thread t1 = new Thread(() -> System.out.println("T1 执行"));
        Thread t2 = new Thread(() -> System.out.println("T2 执行"));
        Thread t3 = new Thread(() -> System.out.println("T3 执行"));

        t1.start();
        t1.join();  // 主线程等 t1 跑完
        t2.start();
        t2.join();  // 主线程等 t2 跑完
        t3.start();
        t3.join();
    }

    public static void test2(){
        CompletableFuture.runAsync(() -> System.out.println("T1"))
                .thenRun(() -> System.out.println("T2"))
                .thenRun(() -> System.out.println("T3"))
                .join();  // 等待整个链执行完

    }


}
