package geektime.spring.demo.hellospring.algorithm.stack;

import java.util.Stack;

public class MyQueue {

    private Stack<Integer> input;

    private Stack<Integer> output;

    private int inputSize;

    private int outputSize;

    /** Initialize your data structure here. */
    public MyQueue() {

        input = new Stack<>();
        output = new Stack<>();
        inputSize = 0;
        outputSize = 0;
    }

    /** Push element x to the back of queue. */
    public synchronized void push(int x) {

        // 如果输出栈里面还有元素，需要将剩余的元素放在输入栈中，跟本次调用输入的数字优先压入输入栈中，再将新的参数压入，保证老元素未弹出的时候，一定比新元素在最终的输出结果中靠前。
        if (outputSize > 0) {

            int length = outputSize;
            for (int i = 0; i < length; i++) {

                outputSize--;
                int leftNumber = output.pop();
                inputSize++;
                input.push(leftNumber);
            }
        }

        inputSize++;
        input.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public synchronized int pop() {

        if (outputSize > 0) {

            outputSize--;
            return output.pop();
        }

        if (inputSize > 0) {

            int length = inputSize;
            for (int i = 0; i < length; i++) {

                inputSize--;
                int number = input.pop();
                outputSize++;
                output.push(number);
            }

            outputSize--;
            return output.pop();
        } else {

            throw new NullPointerException("pop no Elements");
        }

    }

    /** Get the front element. */
    public int peek() {

        if (outputSize > 0) {

            // 如果输出栈有元素就获取栈顶元素。
            return output.peek();
        }

        if (inputSize > 0) {

            // 如果输出栈没有元素，就把输入栈的栈低元素返回。
            return input.firstElement();
        }

        throw new NullPointerException("peek no elements");
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {

        if (inputSize == 0 && outputSize == 0) {

            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        int number1 = 1;
        int number2 = 2;
        int number3 = 3;
        int number4 = 4;
        int number5 = 5;
        int number6 = 6;

        MyQueue myQueue = new MyQueue();
        myQueue.push(number1);
        myQueue.push(number2);
        myQueue.push(number3);
        myQueue.push(number4);
        myQueue.push(number5);
        myQueue.push(number6);

        int pop = myQueue.pop();
        int peek = myQueue.peek();
        boolean isEmpty = myQueue.empty();
        int inputSize = myQueue.inputSize;
        int outputSize = myQueue.outputSize;

        System.out.println(pop);
        System.out.println(peek);
        System.out.println(isEmpty);
        System.out.println(inputSize);
        System.out.println(outputSize);

    }
}
