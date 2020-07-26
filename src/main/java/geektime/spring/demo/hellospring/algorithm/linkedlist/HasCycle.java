package geektime.spring.demo.hellospring.algorithm.linkedlist;

import geektime.spring.demo.hellospring.algorithm.definition.ListNode;

import java.util.HashSet;

/**
 * leecode 141 判断链表是否有环
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {

        HashSet<ListNode> set = new HashSet<>();

        while (head != null) {

            if (set.contains(head)) {

                return true;
            } else {

                set.add(head);
            }

            head = head.next;
        }

        return false;
    }

    public boolean hasCycle2(ListNode head) {

        if (head == null || head.next == null) {

            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while(slow != fast) {

            if (fast == null || fast.next == null) {

                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
