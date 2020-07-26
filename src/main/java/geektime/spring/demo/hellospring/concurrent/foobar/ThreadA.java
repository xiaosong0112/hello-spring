package geektime.spring.demo.hellospring.concurrent.foobar;

import java.util.concurrent.BrokenBarrierException;

public class ThreadA extends Thread {

    private CyclicBarrierDemo cyclicBarrierDemo;

    private Runnable print;

    public ThreadA(CyclicBarrierDemo cyclicBarrierDemo, Runnable print) {

        this.cyclicBarrierDemo = cyclicBarrierDemo;
        this.print = print;
    }

    @Override
    public void run() {
        try {
            cyclicBarrierDemo.foo(print);
        } catch (BrokenBarrierException e) {
            System.out.println(Thread.currentThread().getName() + " barrier broken exception");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " print foo interrupted");
        }
    }
}
