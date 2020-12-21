package java8.Lambda;

/**
 * @Author: wanghuadong
 * @Date: 2020/12/19 11:54
 * @Version: 1.0
 */

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * 一。lambda 表达式的基础语法：java8中引入了一个新的操作符“->”,该操作符称为箭头操作符或Lambda擦偶作福
 * 左侧：Lambda表达式的参数列表。
 * 右侧：Lambda 表达式中所需执行的功能，即Lambda体
 *
 * 语法格式：
 *        1.无参数，无返回值
 *        （） -> System.out.printIn();
 *        2.有一个参数，且无返回值
 *        3.若只有一个参数，小括号可以省略不写
 *        4.有两个及以上参数，有返回值，并且Lambda体中有多条语句
 *        5.若Lambda体中只有一条语句，return和大括号都可以省略不写。
 *        6.Lambda表达式的参数列表的数据类型可以省略不写，因为jvm编译器通过上下文推断出，数据类型，即“类型推断”
 * 二、Lambda 表达式需要“函数式接口”的支持。
 * 函数式接口：接口中只有一个抽象方法的接口，称为函数式接口。可以使用注解@FunctionalInterface 修饰
 * 可以检查是否是函数式接口。
 */
public class a_基础语法 {
    /**
     *  1.无参数，无返回值
     */
    @Test
    public void test1(){
        Runnable r1 = () -> System.out.println("Hello Lambda");
        r1.run();
    }
    /**
     * 2.有一个参数，且无返回值
     */
    @Test
    public void test2(){
        Consumer<String> con = x -> System.out.println(x);
        con.accept("haha");
    }

    /**
     *  4.有两个及以上参数，有返回值，并且Lambda体中有多条语句
     */
    @Test
    public void test3(){
        Comparator<Integer> com = (x,y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x,y);
        };
        System.out.println(com.compare(3,2));
    }

    /**
     * 5.若Lambda体中只有一条语句，return和大括号都可以省略不写。
     */
    public void test4(){
        Comparator<Integer> com  = (x,y) -> Integer.compare(x,y);
    }

}
