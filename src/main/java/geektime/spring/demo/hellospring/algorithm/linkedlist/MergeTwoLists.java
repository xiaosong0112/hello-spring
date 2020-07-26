package geektime.spring.demo.hellospring.algorithm.linkedlist;

import geektime.spring.demo.hellospring.algorithm.definition.ListNode;

public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode node1, ListNode node2) {

        if (node1 == null) {

            return node2;
        }

        if (node2 == null) {

            return node1;
        }

        // 定义哨兵节点
        ListNode current = new ListNode(-1);

        ListNode firstNode = node1;
        ListNode secondNode = node2;
        ListNode result = current;

        while(firstNode != null && secondNode != null) {

            if (firstNode.val < secondNode.val) {

                current.next = new ListNode(firstNode.val);
                firstNode = firstNode.next;
            } else {

                current.next = new ListNode(secondNode.val);
                secondNode = secondNode.next;
            }

            current = current.next;
        }

        while (firstNode != null) {

            current.next = new ListNode(firstNode.val);
            firstNode = firstNode.next;
            current = current.next;
        }

        while (secondNode != null) {

            current.next = new ListNode(secondNode.val);
            secondNode = secondNode.next;
            current = current.next;
        }

        return result.next;
    }
}
