package geektime.spring.demo.hellospring.algorithm.priorityqueue;

import java.util.PriorityQueue;

public class KthLargest {

    // 成员变量参数k
    private int k;

    // 成员变量参数数组
    private int[] nums;

    // 创建最小堆
    private PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {

        this.k = k;
        this.nums = nums;
        for (int number : nums) {

            add(number);
        }

    }

    public int add(int val) {

        if (priorityQueue.size() < k) {

            priorityQueue.add(val);
            return priorityQueue.element();

        } else {

            if (val > priorityQueue.element()) {

                priorityQueue.poll();
                priorityQueue.offer(val);
            }
        }

        return priorityQueue.element();
    }
}
