package test;

public class Test28 {
        private static volatile boolean flag = false;

        public static void main(String[] args) throws InterruptedException {
            new Thread(() -> {
                while (!flag) {
                    // 空转
                }
                System.out.println("Thread terminated.");
            }).start();

            Thread.sleep(1000);
            flag = true; // 没有 volatile，这个改变对其他线程不可见
        }

    }
