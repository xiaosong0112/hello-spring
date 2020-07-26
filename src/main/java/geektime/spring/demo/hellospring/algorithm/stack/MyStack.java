package geektime.spring.demo.hellospring.algorithm.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/implement-stack-using-queues/solution/yong-dui-lie-shi-xian-zhan-by-leetcode/
 * 解题思路
 */
public class MyStack {

    private Queue<Integer> q1;

    private Queue<Integer> q2;

    int top;

    // 方法一
    // push的时候新元素加入队列1的末尾 并保存队列1的末尾元素作为当前栈的栈顶元素
    // pop的时候将所有元素移动到队列2，每个当队列1中的元素等于当前栈顶元素的时候进行出栈操作。

    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
        top = 0;
    }

    /** Push element x onto stack. */
    public synchronized void push(int x) {

        q1.add(x);
        top = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public synchronized int pop() {

        while(q1.size() > 1) {

            // 遍历是为了获取最后一个进入队列的值，让它先出列。在这之前把其他的先倒到另外一个队列中
            Integer number = q1.remove();
            top = number;
            q2.add(number);
        }

        // 最后剩下的这个就是最后进入队列的
        int result = q1.remove();

        // 让输入队列和输出队列进行交换，下次pop的时候还是这个过程。
        Queue temp = q1;
        q1 = q2;
        q2 = temp;

        // 返回这个最后进入队列的值
        return result;
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        Integer element = queue.element();
        Integer remove = queue.remove();
        Integer peek = queue.peek();
        Integer poll = queue.poll();

        //
        System.out.println(element);
        System.out.println(remove);
        System.out.println(peek);
        System.out.println(poll);

    }
}
