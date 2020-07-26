package geektime.spring.demo.hellospring.algorithm.linkedlist;

/**
 * 实现单向链表
 */
public class SingleLinkedList {

    // 定义链表大小
    private int size;

    // 定义头部节点
    private Node head;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public SingleLinkedList() {


    }

    public SingleLinkedList(Node node) {

        this.head = node;
    }

    /**
     * 在链表头部加节点
     * @param previous
     */
    public void addFirst(Node previous) {

        // 说明是头节点
        if (size == 0) {

            head = previous;
        } else {

            previous.next = head;
            head = previous;
        }

        size++;
    }

    /**
     * 在链表头部删除节点
     */
    public void deleteNode() {

        if(head != null) {

            head = head.next;
        }

        size--;
    }

    public void deleteSameNode() {

        // 因为是链表，表示一个链表需要保存住头部节点的地址。如果直接操作head的地址，head的原地址会丢失，倒是链表的节点就会在链表上丢失。
        Node currentNode = head;

        while(currentNode!= null && currentNode.next != null) {

            if (currentNode.value.equals(currentNode.next.value)) {

                currentNode.next = currentNode.next.next;
                size--;
            } else {

                currentNode = currentNode.next;
            }
        }
    }

    public static void main(String[] args) {

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        Node node1 = new Node("1", null);
        Node node2 = new Node("1", node1);
        Node node3 = new Node("2", node2);
        Node node4 = new Node("2", node3);
        Node node5 = new Node("3", node4);
        singleLinkedList.addFirst(node1);
        singleLinkedList.addFirst(node2);
        singleLinkedList.addFirst(node3);
        singleLinkedList.addFirst(node4);
        singleLinkedList.addFirst(node5);

        singleLinkedList.deleteSameNode();
//        singleLinkedList.deleteNode();
//        singleLinkedList.deleteNode();
//        singleLinkedList.deleteNode();
//        singleLinkedList.deleteNode();
//        singleLinkedList.deleteNode();

//        Node node = singleLinkedList.deleteSameNode();
        singleLinkedList.getSize();


    }
}
