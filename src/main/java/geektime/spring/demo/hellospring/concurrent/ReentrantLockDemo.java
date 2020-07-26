package geektime.spring.demo.hellospring.concurrent;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock(true);
        final Condition notfull = lock.newCondition();
        final Condition notEmpty = lock.newCondition();

        // 初始化5个许可证
        Semaphore semaphore = new Semaphore(5);
        try {
            // 获取一个许可证，自然就少一个。
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 释放一个许可证，自然就多一个。
        semaphore.release();
    }
}
