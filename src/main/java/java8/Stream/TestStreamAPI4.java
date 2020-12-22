package java8.Stream;

import java8.类.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @Author: wanghuadong
 * @Date: 2020/12/21 20:00
 * @Version: 1.0
 */
public class TestStreamAPI4 {
    /**
     * 1.给定一个数字列表，如何返回一个由每个数的平方构成的列表
     * 给定【1,2,3,4,5】 返回【1,4,9,16,25】
     */
    @Test
    public void test1(){
        Integer[] integers = {1, 2, 3, 4, 5};
        Arrays.stream(integers).map((x) -> x * x).forEach(System.out::println);
    }

    /**
     * 怎样用map和reduce方法来数一数流中有多少个Employee呢？
     */
    @Test
    public void test2(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1,"huahua",18,10.12));
        list.add(new Employee(2,"heihei",19,20.21));
        list.add(new Employee(3,"gaga",20,30.12));
        list.add(new Employee(4,"huhu",21,40.12));

        Optional<Integer> reduce = list.stream()
                .map((e) -> 1)
                .reduce(Integer::sum);
        System.out.println(reduce.get());
    }
}
