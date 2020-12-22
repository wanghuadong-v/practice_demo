package java8.Stream;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;

/**
 * @Author: wanghuadong
 * @Date: 2020/12/21 21:10
 * @Version: 1.0
 */
public class TestSreamAPI5 {
    /**
     * java8 并行流
     */
    @Test
    public void test(){
        Instant start = Instant.now();
        LongStream.rangeClosed(0,100000000000L)
                .parallel()
//                .sequential()  //设置为串行流
                .reduce(0,Long::sum);
        Instant end = Instant.now();
        System.out.println("耗费时间为：" + Duration.between(start,end).toMillis());
    }


}
