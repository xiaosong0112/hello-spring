package geektime.spring.demo.hellospring.practise;

import geektime.spring.demo.hellospring.algorithm.definition.ListNode;

/**
 * 合并两个链表
 */
public class MergeTwoLists {

    /**
     * 合并升序两个链表，返回的也是升序链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {

            return l2;
        }

        if (l2 == null) {

            return l1;
        }

        ListNode node1 = l1;
        ListNode node2 = l2;

        ListNode guard = new ListNode(-1);
        ListNode currentNode = guard;

        // 遍历链表 然后分别比较两个元素，将比较小的元素放到新的链表中。
        while(node1 != null && node2 != null) {

            if (node1.val < node2.val) {

                currentNode.next = new ListNode(node1.val);
                node1 = node1.next;
            } else {

                currentNode.next = new ListNode(node2.val);
                node2 = node2.next;
            }

            currentNode = currentNode.next;
        }

        // 因为是有序序列，那么比较完了，如果还有剩余的元素直接拼装到新定义的链表上就可以了。
        while (node1 != null) {

            currentNode = new ListNode(node1.val);
            currentNode = currentNode.next;
            node1 = node1.next;
        }

        while (node2 != null) {

            currentNode = new ListNode(node2.val);
            currentNode = currentNode.next;
            node2= node2.next;
        }

        return guard.next;
    }
}
