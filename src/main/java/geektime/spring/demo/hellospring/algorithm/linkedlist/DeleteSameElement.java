package geektime.spring.demo.hellospring.algorithm.linkedlist;

import geektime.spring.demo.hellospring.algorithm.definition.ListNode;

/**
 * leecode 83 删除排序链表中的重复元素，使每一个元素只出现一次
 */
public class DeleteSameElement {

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {

            // 如果链表为null或者只有一个元素则直接返回head，因为不可能有重复元素
            if (head == null || head.next == null) {

                return head;
            }

            ListNode currentNode = head;

            while (currentNode.next != null) {

                // 当 当前节点的值和下个节点的值
                if (currentNode.val == currentNode.next.val) {

                    // 将当前节点的next指向 currentNode.next.next
                    currentNode.next = currentNode.next.next;
                } else {

                    currentNode = currentNode.next;
                }
            }

            return head;
        }
    }
}
