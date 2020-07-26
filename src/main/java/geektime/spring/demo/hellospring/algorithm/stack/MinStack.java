package geektime.spring.demo.hellospring.algorithm.stack;

import java.util.Stack;

/**
 * 实现栈的最小元素的方法（俗称最小栈问题）
 */
public class MinStack {

    private Stack<Integer> stack;

    private Stack<Integer> helperStack;

    public MinStack () {

        stack = new Stack<>();
        helperStack = new Stack<>();
    }

    /**
     * 入栈
     * @param x
     */
    public void push(int x) {

        // 数据栈可以直接压入
        stack.push(x);

        if (helperStack.isEmpty() || x <= helperStack.peek()) {

            // 辅助栈中没有元素的时候直接压入
            helperStack.push(x);
        }
    }

    /**
     * 出栈
     */
    public void pop() {

        if (!stack.isEmpty()) {

            int popNumber = stack.pop();

            // 如果出栈的数字如果就是最小的那个
            if (popNumber == helperStack.peek()) {

                helperStack.pop();
            }
        }
    }

    /**
     * 获取栈顶元素
     * @return
     */
    public int top() {

        if (!stack.isEmpty()) {

            return stack.peek();
        }

        throw new NullPointerException("There is no Elements in stack");
    }

    /**
     * 获取栈中最小值
     * @return
     */
    public int getMin() {

        if (!helperStack.isEmpty()) {

            // 获取helperStack中的最小值。
            return helperStack.peek();
        }

        throw new NullPointerException("There is no Elements in helperStack");
    }
}
