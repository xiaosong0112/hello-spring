package geektime.spring.demo.hellospring.algorithm.definition;

import geektime.spring.demo.hellospring.algorithm.linkedlist.Node;

/**
 * https://www.cnblogs.com/ysocean/p/7928988.html#_label1_0
 */
public class DoubleLinkedList {

    private int size;

    private Node head;

    private Node tail;

    public DoubleLinkedList() {


    }

    public DoubleLinkedList(Node node) {

        this.head = node;
        this.tail = node;
    }

    public void addLast(Node node) {

        if (size == 0) {

            this.head = node;
            this.tail = node;
        } else {

            tail.next = node;
            tail = node;
        }
    }

}
