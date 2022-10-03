package geektime.spring.demo.hellospring.jdk.forkjoin;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 多线程累加数组元素
 * https://my.oschina.net/u/566591/blog/1532135
 */
public class ForkJoinSumTask extends RecursiveTask<Integer> {

    private int leftIndex;

    private int rightIndex;

    private static int[] result;

    public ForkJoinSumTask(int leftIndex, int rightIndex) {
        this.leftIndex = leftIndex;
        this.rightIndex = rightIndex;
    }

    // 线程数量 100
    private static int threadNumber = 100;

    private ThreadPoolExecutor threadPoolExecutor;

    // 任务阈值 超过了阈值就进行分治操作
    private int threshHold = 10000;

    public static int[] getNumberArray(int length) {

        result = new int[length];

        for (int i = 0; i < length; i++) {

            Random random = new Random();

            int max = 100;
            int min = 30;

            // 生成范围随机数 max - min + 1  用固定的数字可以验证算法是否正确。
            int number = random.nextInt(max - min + 1) + threadNumber;
//            int number = 1;
            result[i] = number;
        }

        return result;
    }

    @Override
    protected Integer compute() {

        int sum = 0;

        int length = rightIndex - leftIndex;

        if (length <= threshHold) {

            for (int i = leftIndex; i < rightIndex; i++) {

                sum += result[i];
            }
        } else {

            int middle = length / 2;

            ForkJoinSumTask leftTask = new ForkJoinSumTask(0, middle + 1);
            ForkJoinSumTask rightTask = new ForkJoinSumTask(middle + 1, length);

            leftTask.fork();
            rightTask.fork();

            int sumLeft = leftTask.join();
            int sumRight = rightTask.join();
            sum = sumLeft + sumRight;
        }

        return sum;
    }

    public static void main(String[] args) {

        ForkJoinSumTask.getNumberArray(200);
        ForkJoinSumTask forkJoinSumTask = new ForkJoinSumTask(0, 200);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        int sum = forkJoinPool.invoke(forkJoinSumTask);
        System.out.println(sum);
    }
}
