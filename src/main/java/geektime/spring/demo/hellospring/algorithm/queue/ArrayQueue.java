package geektime.spring.demo.hellospring.algorithm.queue;

/**
 * 用数组实现队列
 */
public class ArrayQueue {

    private String[] items;

    // 队列大小
    private int size;

    private int head;

    private int tail;

    public ArrayQueue(int capacity) {

        size = capacity;
        items = new String[capacity];
    }

    // 入队
    public boolean enqueue(String item) {

        if (tail == size) {

            return false;
        }

        items[tail] = item;
        ++tail;
        return true;
    }

    public String dequeue() {

        if (tail == head) {

            return null;
        }

        String ret = items[head];
        head++;
        return ret;
    }

    public int size() {

        return size;
    }

    public String peek() {

        if (tail == head) {

            return null;
        }

        return items[head];
    }

    public static void main(String[] args) {

        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.enqueue("aa");
        arrayQueue.enqueue("bb");
        arrayQueue.enqueue("cc");
        arrayQueue.enqueue("dd");
        arrayQueue.enqueue("ee");
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());

    }

}
