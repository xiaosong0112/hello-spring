package geektime.spring.demo.hellospring.algorithm.stack;

import java.util.Stack;

/**
 * leecode 1021 删除最外层的括号
 */
public class RemoveOuterParentheses {

    /**
     * 思路是用层级的方式统计当前是不是最外的那层扩号。
     * @param s
     * @return
     */
    public String removeOuterParentheses(String s) {

        if (s == null) {

            return s;
        }

        char[] chars = s.toCharArray();

        if (chars.length == 0) {

            return s;
        }

        StringBuilder sb = new StringBuilder();

        int level = 0;

        for (char c : chars) {

            if (c == ')') {

                level--;
            }

            if (c == '(') {

                level++;
            }

            if (level >= 1) {

                sb.append(c);
            }
        }

        return sb.toString();
    }

    /**
     * 用栈的方式实现删除最外面的一层括号（思路其实和方法一一样，只不过统计用了栈）
     * @param s
     * @return
     */
    public String removeOuterParentheses2(String s) {

        if (s == null) {

            return s;
        }

        if (s.length() == 0) {

            return s;
        }

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        char[] chars = s.toCharArray();

        for (char c : chars) {

            if (c == ')') {

                stack.pop();
            }

            if (stack.size() >= 1) {

                sb.append(c);
            }

            if (c == '(') {

                stack.push(c);
            }
        }

        return sb.toString();
    }


}
