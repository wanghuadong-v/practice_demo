package java8.b_Lambda;

/**
 * @Author: wanghuadong
 * @Date: 2020/12/20 10:11
 * @Version: 1.0
 */

import java8.a_类.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.*;

/**
 * 一、方法引用：若Lambda体中的内容有方法已经实现，我们可以使用“方法引用”。
 *          （可以理解为方法引用是Lambda表达式的另外一种表现形式）
 *  主要有三种语法格式：
 *      对象：：实例方法名
 *      类：：静态方法名
 *      类：：实例方法名
 *
 * 注意：1。Lambda体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的函数列表和返回值类型保持一致
 *      2.若 Lambda参数列表中的第一个参数是 实例方法 的调用者，而第二个参数是实例方法的参数时，可以使用 ClassName：：method
 * 二、构造器引用：
 *      格式；ClassName：：new
 * 三、数组引用：
 * Type :: new
 */
public class c_方法引用 {

    //数组引用
    @Test
    public void test8(){
        Function<Integer, String[]> fun = (args) -> new String[args];
        String[] strs = fun.apply(10);
        System.out.println(strs.length);

        System.out.println("--------------------------");

        Function<Integer, Employee[]> fun2 = Employee[] :: new;
        Employee[] emps = fun2.apply(20);
        System.out.println(emps.length);
    }

    //构造器引用
    @Test
    public void test7(){
        Function<String, Employee> fun = Employee::new;

        BiFunction<String, Integer, Employee> fun2 = Employee::new;
    }

    @Test
    public void test6(){
        Supplier<Employee> sup = () -> new Employee();
        System.out.println(sup.get());

        System.out.println("------------------------------------");

        Supplier<Employee> sup2 = Employee::new;
        System.out.println(sup2.get());
    }

    //类名 :: 实例方法名
    @Test
    public void test5(){
        BiPredicate<String, String> bp = (x, y) -> x.equals(y);
        System.out.println(bp.test("abcde", "abcde"));

        System.out.println("-----------------------------------------");

        BiPredicate<String, String> bp2 = String::equals;
        System.out.println(bp2.test("abc", "abc"));

        System.out.println("-----------------------------------------");


        Function<Employee, String> fun = (e) -> e.show();
        System.out.println(fun.apply(new Employee()));

        System.out.println("-----------------------------------------");

        Function<Employee, String> fun2 = Employee::show;
        System.out.println(fun2.apply(new Employee()));

    }

    //类名 :: 静态方法名
    @Test
    public void test4(){
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);

        System.out.println("-------------------------------------");

        Comparator<Integer> com2 = Integer::compare;
    }

    @Test
    public void test3(){
        BiFunction<Double, Double, Double> fun = (x, y) -> Math.max(x, y);
        System.out.println(fun.apply(1.5, 22.2));

        System.out.println("--------------------------------------------------");

        BiFunction<Double, Double, Double> fun2 = Math::max;
        System.out.println(fun2.apply(1.2, 1.5));
    }

    //对象的引用 :: 实例方法名
    @Test
    public void test2(){
        Employee emp = new Employee(101, "张三", 18, 9999.99);

        Supplier<String> sup = () -> emp.getName();
        System.out.println(sup.get());

        System.out.println("----------------------------------");

        Supplier<String> sup2 = emp::getName;
        System.out.println(sup2.get());
    }

    @Test
    public void test1(){
        PrintStream ps = System.out;
        Consumer<String> con = (str) -> ps.println(str);
        con.accept("Hello World！");
        System.out.println("--------------------------------");
        Consumer<String> con2 = ps::println;
        con2.accept("Hello Java8！");
        Consumer<String> con3 = System.out::println;
    }
}
