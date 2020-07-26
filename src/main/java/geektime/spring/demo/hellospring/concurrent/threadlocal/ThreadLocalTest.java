package geektime.spring.demo.hellospring.concurrent.threadlocal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ThreadLocalTest {

    static final ThreadLocal<DateFormat> tl = ThreadLocal.withInitial( ()-> new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss"));

    public static void main(String[] args) throws InterruptedException {

        TestThreadLocal testThreadLocal1 = new TestThreadLocal();
        testThreadLocal1.run();
        TestThreadLocal testThreadLocal2 = new TestThreadLocal();
        testThreadLocal2.run();
        testThreadLocal1.join();
        testThreadLocal2.join();
    }
}
