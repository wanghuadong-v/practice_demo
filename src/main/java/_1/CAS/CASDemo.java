package _1.CAS;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 *CAS是什么 -- compareAndSet
 * 比较并交换
 */
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        System.out.println(atomicInteger.compareAndSet(5, 2019) + "\t current data is：" + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 1024) + "\t current data is：" + atomicInteger.get());
    }
}
