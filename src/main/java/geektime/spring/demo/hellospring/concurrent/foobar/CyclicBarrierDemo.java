package geektime.spring.demo.hellospring.concurrent.foobar;

import java.util.concurrent.*;

public class CyclicBarrierDemo {

    private int n;

    private CountDownLatch countDownLatch;

    private CyclicBarrier cyclicBarrier;

    volatile boolean flag = false;

    public CyclicBarrierDemo(int n) {
        this.n = n;
        countDownLatch = new CountDownLatch(1);
        cyclicBarrier = new CyclicBarrier(2);
    }

    public void foo(Runnable printFoo) throws InterruptedException, BrokenBarrierException {

        for (int i = 0; i < n; i++) {

            printFoo.run();
            countDownLatch.countDown();
            cyclicBarrier.await();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException, BrokenBarrierException {

        for (int i = 0; i < n; i++) {

            countDownLatch.await();
            printBar.run();
            cyclicBarrier.await();
        }
    }

    public static void main(String[] args) {

        CyclicBarrierDemo cyclicBarrierDemo = new CyclicBarrierDemo(10);
        PrintFoo printFoo = new PrintFoo();
        PrintBar printBar = new PrintBar();
        ThreadA a = new ThreadA(cyclicBarrierDemo, printFoo);
        ThreadB b = new ThreadB(cyclicBarrierDemo, printBar);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(b);
        executorService.execute(a);

    }
}
