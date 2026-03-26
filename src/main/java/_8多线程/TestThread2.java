package _8多线程;

import java.util.concurrent.CyclicBarrier;

// 测试CyclicBarrier
public class TestThread2 {
    public static void main(String[] args) {
        // 3 个线程分阶段计算，每阶段结束后汇总
        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            System.out.println("所有线程完成当前阶段，开始汇总");
        });

        for (int i = 0; i < 3; i++) {
            int taskId = i;
            new Thread(() -> {
                try {
                    System.out.println("线程 " + taskId + " 完成第一阶段");
                    barrier.await();  // 等待其他线程
                    System.out.println("线程 " + taskId + " 完成第二阶段");
                    barrier.await();  // 屏障可重复使用
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}
