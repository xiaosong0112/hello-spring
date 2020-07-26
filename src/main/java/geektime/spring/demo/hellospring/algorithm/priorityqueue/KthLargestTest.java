package geektime.spring.demo.hellospring.algorithm.priorityqueue;

import org.junit.Test;

import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;

public class KthLargestTest {

    @Test
    public void add() {

        int k = 3;
        int[] arr = new int[] { 4, 5, 8, 2 };
        KthLargest kthLargest = new KthLargest(k, arr);
        assertEquals(4, kthLargest.add(3));
        assertEquals(5, kthLargest.add(5));
        assertEquals(5, kthLargest.add(10));
        assertEquals(8, kthLargest.add(9));
        assertEquals(8, kthLargest.add(4));

        PriorityQueue priorityQueue = new PriorityQueue();

        for (int number: arr) {

            priorityQueue.add(number);
        }

        System.out.println(priorityQueue.peek());

    }
}
