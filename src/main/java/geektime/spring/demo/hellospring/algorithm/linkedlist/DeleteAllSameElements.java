package geektime.spring.demo.hellospring.algorithm.linkedlist;

import geektime.spring.demo.hellospring.algorithm.definition.ListNode;

/**
 * 删除排序链表中的所有的重复元素
 */
public class DeleteAllSameElements {

    public ListNode deleteDuplicates(ListNode head) {

        // 如果head节点为空或者 head节点只有一个元素 则直接返回head
        if (head == null || head.next == null) {

            return head;
        }

        ListNode guard = new ListNode(-99);

        guard.next = head;

        // 用于后续遍历head
        ListNode currentNode = head;

        // 保存前面的节点，用于删除当前节点
        ListNode prev = guard;

        while (currentNode != null && currentNode.next != null) {

            // 值相等的时候，对前一个节点进行操作。
            if (currentNode.val == currentNode.next.val) {

                // 找到最后一个重复节点
                while (currentNode != null && currentNode.next != null && currentNode.val == currentNode.next.val) {

                    currentNode = currentNode.next;
                }
                // 如果头节点就相等了，那直接略过这两个节点
                prev.next = currentNode.next.next;
                // 移动当前节点到下下个节点。
                currentNode = currentNode.next.next;
            } else {

                prev = currentNode;
                currentNode = currentNode.next;
            }
        }

        return guard.next;
    }
}
