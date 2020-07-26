package geektime.spring.demo.hellospring.concurrent.foobar;

import java.util.concurrent.BrokenBarrierException;

public class ThreadB extends Thread {

    private CyclicBarrierDemo cyclicBarrierDemo;

    private Runnable print;

    public ThreadB(CyclicBarrierDemo cyclicBarrierDemo, Runnable print) {

        this.cyclicBarrierDemo = cyclicBarrierDemo;
        this.print = print;
    }

    @Override
    public void run() {
        try {
            cyclicBarrierDemo.bar(print);
        } catch (BrokenBarrierException e) {
            System.out.println(Thread.currentThread().getName() + " barrier broken exception");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " print bar Interruptted");
        }
    }
}
