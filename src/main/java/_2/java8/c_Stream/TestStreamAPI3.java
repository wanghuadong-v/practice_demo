package _2.java8.c_Stream;

import _2.java8.a_类.Employee;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: wanghuadong
 * @Date: 2020/12/20 20:34
 * @Version: 1.0
 */
public class TestStreamAPI3 {
    /**
     * 查找和匹配
     * allMatch-检查是否匹配所有元素
     * anyMatch-检查是否至少匹配一个元素
     * noneMatch-检查是否没有匹配所有元素
     * findFirst-返回第一个元素
     * findAny-返回当前流中的任意元素
     * count-返回流中元素的总个数
     * max-返回流中的最大值
     * min-返回流中的最小值
     */
    @Test
    public void test1(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1,"huahua",18,10.12));
        list.add(new Employee(2,"heihei",19,20.21));
        list.add(new Employee(3,"gaga",20,30.12));
        list.add(new Employee(4,"huhu",21,40.12));

        boolean b = list.stream().anyMatch((e) -> e.getId() >= 1);
        System.out.println(b);
        long count = list.parallelStream().count();
        System.out.println(count);
    }
    /**
     * 归约
     * reduce（T identity，BinaryOperator/reduce(BinaryOperator)）---可以将流中元素反复结合起来，得到一个值
     *
     */
    @Test
    public void test2(){
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = integers.stream()
                .reduce(0, (x, y) -> x + y);
        System.out.println(reduce);
        System.out.println("---------------------");
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1,"huahua",18,10.12));
        list.add(new Employee(2,"heihei",19,20.21));
        list.add(new Employee(3,"gaga",20,30.12));
        list.add(new Employee(4,"huhu",21,40.12));
        //可能为空的封装到 option 中去
        Optional<Double> reduce1 = list.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(reduce1.get());
    }

    /**
     * 收集
     * collect-将流装换为其他形式。接收一个Collection接口的实现，用于给Stream中元素做汇总的方法。
     */
    @Test
    public void test3(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1,"huahua",18,10.12));
        list.add(new Employee(2,"heihei",19,20.21));
        list.add(new Employee(3,"gaga",20,30.12));
        list.add(new Employee(4,"huhu",21,40.12));
        List<String> collect = list.stream().map(Employee::getName).collect(Collectors.toList());
        collect.forEach(System.out::println);

        DoubleSummaryStatistics collect1 = list.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(collect1.getSum());

        /**
         * 分组
         */

    }
}
