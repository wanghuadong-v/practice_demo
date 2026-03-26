package test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test22 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 方式1：继承Thread类
        Thread1 thread1 = new Thread1();
        thread1.start();

        // 方式2：实现Runnable接口
        Runnable runnable = new Thread2();
        Thread thread2 = new Thread(runnable);
        thread2.start();

        // 方式3：实现Callable接口
        Callable<Integer> callable = new Thread3();
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread thread3 = new Thread(futureTask);
        thread3.start();
        // 获取Callable的返回值
        Integer result = futureTask.get();
        System.out.println("Callable返回结果：" + result);
    }

    // 方式1：继承Thread类
    static class Thread1 extends Thread {
        @Override
        public void run() {
            System.out.println("方式1：继承Thread类 - 线程运行中");
        }
    }

    // 方式2：实现Runnable接口
    static class Thread2 implements Runnable {
        @Override
        public void run() {
            System.out.println("方式2：实现Runnable接口 - 线程运行中");
        }
    }

    // 方式3：实现Callable接口
    static class Thread3 implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            System.out.println("方式3：实现Callable接口 - 线程运行中");
            return 123;
        }
    }
}