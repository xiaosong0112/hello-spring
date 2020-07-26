package geektime.spring.demo.hellospring.algorithm.linkedlist;

import geektime.spring.demo.hellospring.algorithm.definition.ListNode;

import java.util.Arrays;

/**
 * 中间节点
 */
public class MiddleNode {

    /**
     * 快慢指针的算法
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {

        int[] param = new int[]{0,1,2,3,4,5};
        Arrays.sort(param);
        for (int number : param) {

            System.out.println(number);
        }

    }
}
