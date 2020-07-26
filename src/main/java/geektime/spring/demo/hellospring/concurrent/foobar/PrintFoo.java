package geektime.spring.demo.hellospring.concurrent.foobar;

public class PrintFoo implements Runnable {

    @Override
    public void run() {
        System.out.println("foo");
    }
}
