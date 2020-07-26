package geektime.spring.demo.hellospring.concurrent;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    public static void main(String[] args) throws InterruptedException {

        Semaphore noFairSemaphore = new Semaphore(5);
        boolean isFair = noFairSemaphore.isFair();
        System.out.println(isFair);

        Semaphore fairSemaphore = new Semaphore(5, true);
        isFair = fairSemaphore.isFair();
        System.out.println(isFair);

        // acquire和release方法回操作信号量中state变量。
        // acquire 会减少1
        fairSemaphore.acquire();
        System.out.println(fairSemaphore.availablePermits());
        fairSemaphore.acquire();
        System.out.println(fairSemaphore.availablePermits());
        // release会加1
        fairSemaphore.release();
        System.out.println(fairSemaphore.availablePermits());
    }
}
