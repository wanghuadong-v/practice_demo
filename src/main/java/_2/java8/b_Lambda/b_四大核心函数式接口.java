package _2.java8.b_Lambda;

/**
 * @Author: wanghuadong
 * @Date: 2020/12/19 16:14
 * @Version: 1.0
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * java8 内置的四大核心函数式接口
 * Consumer<T> : 消费型接口
 *      void accept<T t>
 * Supplier<T> : 供给姓接口
 *         T get()
 * Function<T,R> : 函数型接口
 *         R apply(T t);
 *
 * Predicate<T> : 断言型接口。
 *   boolean test（T t）；
 */
public class b_四大核心函数式接口 {
    /**
     * Consumer<T> : 消费型接口
     */
    @Test
    public void test1(){
        happy(10000,(mon) -> System.out.println("请丽丽吃饭,消费了：" + mon + "元"));
    }
    public void happy(double money, Consumer<Double> con){
        con.accept(money);
    }

    /**
     * Supplier<T> : 供给姓接口
     */
    @Test
    public void test2(){
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
        for (Integer num : numList){
            System.out.println(num);
        }
    }
    //需求：产生一些数，并且放到集合中
    public List<Integer> getNumList(int num, Supplier<Integer> sup){
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer integer = sup.get();
            integers.add(integer);
        }
        return integers;
    }

    /**
     * Function<T,R> : 函数型接口
     */
    @Test
    public void test3(){
        String s = strHandler("     她今天没理我，哈哈啊    ", (str) -> str.trim());
        System.out.println(s);
        String s1 = strHandler("她今天没理我，哈哈啊", (str) -> str.substring(0,1));
        System.out.println(s1);
    }
    //需求：用于处理字符串
    public String strHandler(String str, Function<String,String> fun){
        return fun.apply(str);
    }

    /**
     * Predicate<T> : 断言型接口。
     */
    @Test
    public void test4(){
        List<String> strings = Arrays.asList("hello", "world", "lili", "cao");
        List<String> strings1 = filterStr(strings, (strs) -> strs.length() > 3);
        for (String s : strings1){
            System.out.println(s);
        }
    }
//    需求：满足条件的字符串，放入集合中
    public List<String> filterStr(List<String> list, Predicate<String> pre){
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (pre.test(list.get(i))){
                strings.add(list.get(i));
            }
        }
        return strings;
    }
}
