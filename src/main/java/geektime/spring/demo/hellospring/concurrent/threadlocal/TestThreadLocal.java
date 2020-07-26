package geektime.spring.demo.hellospring.concurrent.threadlocal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestThreadLocal extends Thread {

    static final ThreadLocal<DateFormat> tl = ThreadLocal.withInitial( ()-> new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss"));

    private TestUser user;

//    private TestThreadLocal(TestUser user) {
//
//        this.user;
//    }

    @Override
    public void run() {

        DateFormat format = tl.get();

//        Thread.sleep(1000);
        String result = format.format(new Date());
        System.out.println(result);
    }
}
