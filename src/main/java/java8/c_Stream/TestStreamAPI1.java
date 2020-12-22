package java8.c_Stream;

/**
 * @Author: wanghuadong
 * @Date: 2020/12/20 11:32
 * @Version: 1.0
 */

import java8.a_类.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 一、Stream的三个操做步骤：
 * 1.创建Stream
 * 2.中间操做
 * 3.终止操做
 */
public class TestStreamAPI1 {

    @Test
    public void test1(){
        /**
         *  * 1、创建Stream
         */
        //1.通过collection 系列集合提供的stream（）或parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        //2.通过Arrays中的静态方法stream()获取数据流
        Employee[] employees = new Employee[10];
        Stream<Employee> stream1 = Arrays.stream(employees);

        //3.通过Stream类中的静态方法of（）
        Stream<String> stream2 = Stream.of("aa", "bb", "cc");

        //4.创建无限流
        //迭代
        Stream<Integer> stream3 = Stream.iterate(0, (x) -> x + 2);
        stream3.forEach(System.out::println);
        //生成
        Stream<Double> stream4 = Stream.generate(() -> Math.random()).limit(5);
    }
}
