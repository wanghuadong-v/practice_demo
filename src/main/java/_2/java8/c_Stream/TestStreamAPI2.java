package _2.java8.c_Stream;

import _2.java8.a_类.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author: wanghuadong
 * @Date: 2020/12/20 15:58
 * @Version: 1.0
 */
public class TestStreamAPI2 {
    /**
     * 筛选与切片
     * filter-接收Lambda，从流中排除某些元素
     * limit-截断流，使其元素不超过给定数量
     * skip（n）-跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流。与limit（n）互补
     * distinct-筛选，通过流所生成元素的hashCode（）和equals（）去除重复元素
     */
    @Test
    public void test1(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1,"huahua",18,10.12));
        list.add(new Employee(2,"heihei",19,20.21));
        list.add(new Employee(3,"gaga",20,30.12));
        list.add(new Employee(4,"huhu",21,40.12));

        Stream<Employee> employeeStream = list.stream().filter((e) -> e.getId() >= 1).limit(2);
        employeeStream.forEach(System.out::println);
    }
    /**
     * 映射
     * map-接收Lambda，将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射为一个新的元素。
     * flatMap-接收一个函数作为参数，将流中的每个值换成另一个流，然后把所有流连成一个流
     */
    @Test
    public void Test2(){
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        list.stream().map((str) -> str.toUpperCase()).forEach(System.out::println);
    }

    /**
     * 排序
     * sorted()-自然排序（Comparable）
     * sorted（Comparable com）-定制排序（Comparator）
     */

    @Test
    public void test3(){
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        list.stream().sorted().forEach(System.out::println);

        System.out.println("---------------------------");
        List<Employee> list1 = new ArrayList<>();
        list1.add(new Employee(1,"huahua",18,10.12));
        list1.add(new Employee(2,"heihei",19,20.21));
        list1.add(new Employee(3,"gaga",20,30.12));
        list1.add(new Employee(4,"huhu",21,40.12));
        list1.stream().sorted((e1,e2) -> {
            return -e1.getId().compareTo(e2.getId());
        }).forEach(System.out::println);
    }
}
