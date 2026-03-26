package _8多线程;

import java.util.concurrent.CountDownLatch;

// 测试 CountDownLatch
public class TestThread3 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        // 启动 3 个子任务
        for (int i = 0; i < 3; i++) {
            int taskId = i;
            new Thread(() -> {
                System.out.println("任务 " + taskId + " 完成");
                latch.countDown();  // 计数器减 1
            }).start();
        }

        System.out.println("等待子任务完成...");
        latch.await();  // 阻塞直到计数器归零
        System.out.println("所有子任务完成，开始汇总");

    }
}
