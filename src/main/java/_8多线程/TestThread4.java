package _8多线程;

import java.util.concurrent.CountDownLatch;

public class TestThread4 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    startSignal.await();  // 所有线程在这里等待
                    System.out.println("执行压测线程" + Thread.currentThread().getName());
                    // 执行压测请求
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }

        Thread.sleep(1000);  // 等线程都就绪
        startSignal.countDown();  // 发令枪响，10 个线程同时冲

    }
}
