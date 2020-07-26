package geektime.spring.demo.hellospring.algorithm.linkedlist;

import geektime.spring.demo.hellospring.algorithm.definition.ListNode;

/**
 * leecode 203 删除链表中所有跟指定参数相同的元素
 */
public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {

        // 因为要删除的元素是循环过程中当前元素的前一个元素，所以需要定义prev前继节点。为了简化程序逻辑，设置哨兵节点
        if (head == null) {
            return head;
        }

        ListNode guard = new ListNode(-1);

        ListNode currentNode = head;
        ListNode prev = guard;

        guard.next = currentNode;

        while (currentNode != null) {

            if (currentNode.val == val) {

                prev.next = currentNode.next;
            } else {

                prev = currentNode;
            }

            currentNode = currentNode.next;
        }

        return guard.next;
    }
}
