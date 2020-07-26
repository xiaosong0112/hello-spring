package geektime.spring.demo.hellospring.algorithm.stack;

import geektime.spring.demo.hellospring.algorithm.definition.ListNode;

public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // 参数校验
        if (l1 == null && l2 == null) {

            return null;
        }

        if (l1 == null) {

            return l2;
        }

        if (l2 == null) {

            return l1;
        }

        int length1 = this.getLength(l1);

        // 定义放置第一个链表元素的数组。
        int[] numbers1 = getNumbers(l1, length1);

        int length2 = getLength(l2);

        int[] numbers2 = getNumbers(l2, length2);

        // 将元素进行排序
        int[] mergeArray = mergeSort(numbers1, numbers2);

        // 重新组成新的链表
        int i = 0;
        ListNode headNode = null;
        ListNode nextNode = null;
        while(i < mergeArray.length) {

            ListNode listNode = new ListNode(mergeArray[i]);

            if (i == 0) {

                headNode = listNode;
                nextNode = listNode;
            } else {

                nextNode.next = listNode;
                nextNode = listNode;
            }
            i++;
        }

        return headNode;
    }

    private int[] getNumbers(ListNode listNode, int length) {

        int[] numbers = new int[length];

        int i = 0;

        // 将元素保存在数组中
        while(listNode != null && i < length) {

            numbers[i] = listNode.val;
            i++;
            listNode = listNode.next;
        }
        return numbers;
    }

    private int getLength(ListNode node) {

        int length = 0;

        ListNode head = node;

        while(head != null) {

            length++;
            head = head.next;
        }

        return length;
    }

    private int[] mergeSort(int[] array1, int[] array2) {

        if (array1 == null && array2 == null) {

            return new int[0];
        }

        // 判断数组参数
        if (array1 == null || array1.length == 0) {

            return array2;
        }

        if (array2 == null || array2.length == 0) {

            return array1;
        }

        // 分别将两个数组进行归并排序，因为已经分别排好了顺序，所以这里只需要对数组元素进行合并。
        int[] mergeArray = new int[array1.length + array2.length];

        // 同步循环指针，将比较后比较小的数字优先放入合并后的数组中。
        int index = 0;
        int index1 = 0;
        int index2 = 0;
        while (index1 < array1.length && index2 < array2.length) {

            if(array1[index1] < array2[index2]) {

                mergeArray[index] = array1[index1];
                index++;
                index1++;
            } else {

                mergeArray[index] = array2[index2];
                index++;
                index2++;
            }
        }

        if (index1 < array1.length) {

            for(int i = index1; i < array1.length; i++) {

                mergeArray[index] = array1[i];
                index++;
            }
        } else {

            for(int i = index2; i < array2.length; i++) {

                mergeArray[index] = array2[i];
                index++;
            }
        }

        return mergeArray;

    }

    public ListNode mergeTwoLists2(ListNode node1, ListNode node2) {

        // 校验参数
        if (node1 == null) {

            return node2;
        }

        if (node2 == null) {

            return node1;
        }

        // 同一个循环中遍历两个链表的元素。
        // 定义结果链表
        ListNode resultHead = new ListNode(0);
        ListNode resultCurrent = new ListNode(0);

        int size = 0;
//        ListNode currentNode1 = node1;
//        ListNode currentNode2 = node2;

        while (node1 != null && node2 != null) {


            if (node1.val < node2.val) {

                ListNode listNode = new ListNode(node1.val);

                if (size == 0) {

                    resultHead = listNode;
                    resultCurrent = resultHead;
                } else {

                    resultCurrent.next = listNode;
                    resultCurrent = listNode;
                }

                size++;
                node1 = node1.next;
            } else {

                ListNode listNode = new ListNode(node2.val);

                if (size == 0) {

                    resultHead = listNode;
                    resultCurrent = resultHead;
                } else {

                    resultCurrent.next = listNode;
                    resultCurrent = listNode;
                }
                size++;
                node2 = node2.next;
            }
        }

        while (node1 != null) {

            ListNode listNode = new ListNode(node1.val);
            resultCurrent.next = listNode;
            resultCurrent = listNode;
            node1 = node1.next;
        }

        while (node2 != null) {

            ListNode listNode = new ListNode(node2.val);
            resultCurrent.next = listNode;
            resultCurrent = listNode;
            node2 = node2.next;
        }

        return resultHead;
    }

    public static void main(String[] args) {

//        ListNode node1 = new ListNode(-2);
//        ListNode node2 = new ListNode(5);
//        node1.next = node2;
//
//
//        ListNode node11 = new ListNode(-9);
//        ListNode node22 = new ListNode(-6);
//        ListNode node33 = new ListNode(-3);
//        ListNode node44 = new ListNode(-1);
//        ListNode node55 = new ListNode(6);
//        node11.next = node22;
//        node22.next = node33;
//        node33.next = node44;
//        node44.next = node55;
//
        MergeTwoLists mergeTwoLists = new MergeTwoLists();
//
//        ListNode resultNode = mergeTwoLists.mergeTwoLists(node1, node11);
//        System.out.println(resultNode);

        ListNode node1111 = new ListNode(1);
        ListNode node2222 = new ListNode(2);
        ListNode node3333 = new ListNode(4);
        node1111.next = node2222;
        node2222.next = node3333;

        ListNode node111 = new ListNode(1);
        ListNode node222 = new ListNode(3);
        ListNode node333 = new ListNode(4);

        node111.next = node222;
        node222.next = node333;
        mergeTwoLists.mergeTwoLists2(node1111, node111);
    }
}
