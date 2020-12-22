package java8.d_Optional;

import java8.a_类.Employee;
import org.junit.Test;

import java.util.Optional;

/**
 * @Author: wanghuadong
 * @Date: 2020/12/22 20:13
 * @Version: 1.0
 */
public class Test1 {
    /**
     * optional: 容器类的常用方法：
     * Optional。of（T t）创建一个optional实例
     * Optional.empty():创建一个空的Optional实例
     * Optional.ofNullable(T t):若t不为null，创建Optional实例，否则创建空实例
     * isPresent():判断是否包含值
     * orElse(T t):如果调用对象包含值，返回该值，否则返回t
     * orElseGet（Supplier s）：如果调用对象包含值，返回该值，否则返回s获取的值
     * map（Function f）：如果有值对其处理，并返回处理后的Optional，否则返回Optional.Empty()
     * flatMap(Function mapper):与map类似，要求返回值必须是Optional
     */
    @Test
    public void test1(){
        Optional<Employee> employee = Optional.of(new Employee());
        Employee employee1 = employee.get();
        System.out.println(employee1);
    }

    @Test
    public void test2(){
        Optional<Employee> empty = Optional.empty();
        if (empty.isPresent()){
            System.out.println(empty.get());
        }
        Employee gaga = empty.orElse(new Employee(3, "gaga", 20, 30.12));
        System.out.println(gaga);
        System.out.println("---------------------------------------------------------");
        Optional<Employee> employee = Optional.ofNullable(new Employee());
        System.out.println(employee.get());

    }

    @Test
    public void test3(){
        Optional<Employee> empty = Optional.empty();
        if (empty.isPresent()){
            System.out.println(empty.get());
        }
        Employee employee = empty.orElseGet(() -> new Employee());
        System.out.println(employee);
    }

    @Test
    public void test4(){
        Optional<Employee> gaga = Optional.ofNullable(new Employee(3, "gaga", 20, 30.12));
        Optional<String> s = gaga.map((e) -> e.getName());
        System.out.println(s.get());

        Optional<Integer> o = gaga.flatMap((e) -> Optional.of(e.getId()));
        System.out.println(o.get());
    }


}
