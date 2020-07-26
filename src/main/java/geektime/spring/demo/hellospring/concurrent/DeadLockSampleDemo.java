package geektime.spring.demo.hellospring.concurrent;


public class DeadLockSampleDemo extends Thread {
    private String first;
    private String second;
    public DeadLockSampleDemo(String name, String first, String second) {
        super(name);
        this.first = first;
        this.second = second;
    }

    public  void run() {
        synchronized (first) {
            System.out.println(this.getName() + " obtained: " + first);
            try {
                Thread.sleep(1000L);
                synchronized (second) {
                    System.out.println(this.getName() + " obtained: " + second);
                }
            } catch (InterruptedException e) {
                // Do nothing
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        String lockA = "lockA";
        String lockB = "lockB";
        DeadLockSampleDemo t1 = new DeadLockSampleDemo("Thread1", lockA, lockB);
        DeadLockSampleDemo t2 = new DeadLockSampleDemo("Thread2", lockB, lockA);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
