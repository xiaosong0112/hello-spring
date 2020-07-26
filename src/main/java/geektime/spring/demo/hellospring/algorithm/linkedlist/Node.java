package geektime.spring.demo.hellospring.algorithm.linkedlist;

public class Node {

    public String value;
    public Node next;

    public Node(String value, Node next) {

        this.value = value;
        this.next = next;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
