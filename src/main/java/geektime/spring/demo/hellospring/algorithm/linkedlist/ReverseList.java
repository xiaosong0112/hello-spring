package geektime.spring.demo.hellospring.algorithm.linkedlist;

import geektime.spring.demo.hellospring.algorithm.definition.ListNode;

public class ReverseList {

    public ListNode reverseList(ListNode head) {

        // 定义返回结果链表
        ListNode prev = null;

        // 所有链表操作都不直接操作参数，将参数进行保存，用保存后的变量进行操作。
        ListNode current = head;

        // 节点不为空就一直循环
        while (current != null) {

            // 先保存下一个节点
            ListNode nextTemp = current.next;

            // 将当前节点的next指向prev节点，反转方向
            current.next = prev;

            // 将prev节点的值赋值成当前节点的值，做为返回节点的头节点，后续的循环会在头节点进行插入操作
            prev = current;

            // 将当前节点移动到下个节点继续循环操作。
            current = nextTemp;
        }

        return prev;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(-1);

        ListNode current = head;
        for (int i = 0; i < 5; i++) {

            current.next = new ListNode(i);
            current = current.next;
        }

        ReverseList reverseList = new ReverseList();

        reverseList.reverseList(head);

    }
}
