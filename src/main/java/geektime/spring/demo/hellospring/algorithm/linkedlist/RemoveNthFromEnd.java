package geektime.spring.demo.hellospring.algorithm.linkedlist;

import geektime.spring.demo.hellospring.algorithm.definition.ListNode;

/**
 * 删除链表的倒数第N个节点
 */
public class RemoveNthFromEnd {

    /**
     * 解法1 两次循环
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // 定义哨兵节点
        ListNode guard = new ListNode(-1);

        // 保存head节点到firstNode
        ListNode firstNode = head;

        // 把哨兵节点指向head节点。也就是保存head节点，后面开始操作firstNode节点的遍历
        guard.next = firstNode;

        int length = 0;

        while(head != null) {

            head = head.next;
            length++;
        }

        // 将firstNode保存到currentNode 开始移动currentNode节点。
        ListNode currentNode = firstNode;
        // 将倒数第n个数换算成从正面数第k个数
        int k = length - n;

        int i = 0;
        ListNode prev = guard;
        while(i <= length) {

            if (i == k) {

                prev.next = currentNode.next;
            } else {
                prev = currentNode;
                currentNode = currentNode.next;
            }

            i++;

        }

        // 加入哨兵就是为了方便的处理边界条件。
        return guard.next;
    }

    /**
     * 解法2 一次循环
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {

        // 定义哨兵节点。
        ListNode guard = new ListNode(-1);
        guard.next = head;

        // 定义双指针
        ListNode firstPoint = guard;
        ListNode secondPoint = guard;

        // 第一个指针走过的长度
        int firstLength = 0;

        while(firstPoint != null) {

            if (firstLength < n + 1) {

                // 只移动第一个指针
                firstPoint = firstPoint.next;
                firstLength++;
            } else {

                // 移动双指针
                firstPoint = firstPoint.next;
                firstLength++;
                secondPoint = secondPoint.next;
            }
        }

        // 当第一个指针到达最后一个节点之后 第二个指针所在的位置就是倒数第n个节点。
        secondPoint.next = secondPoint.next.next;

        return guard.next;
    }

    public static void main(String[] args) {

        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();

        ListNode head = new ListNode(1);
        removeNthFromEnd.removeNthFromEnd(head, 1);
    }
}
