package geektime.spring.demo.hellospring.algorithm.stack;

import java.util.Stack;

/**
 * leecode20 有效的括号
 *
 */
public class ValidBrackets {

    /**
     * 1、判断参数
     * 2、判断奇偶
     * 3、循环
     * @param str
     * @return
     */
    boolean isValid(String str) {

        // 判断字符串的长度。如果是0说明括号配对成功，或者没有单个符号。
        if (str.length() == 0) {

            return true;
        }

        // 判断长度是奇数还是偶数
        if ((str.length() & 1 )== 1) {

            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);

            switch (c) {

                case '[' :
                    stack.push(c);
                    break;
                case '{' :
                    stack.push(c);
                    break;
                case '(' :
                    stack.push(c);
                    break;
                case ']' :
                    if (stack.isEmpty() || stack.pop() != '[') {

                        return false;
                    }
                    continue;
                case '}' :
                    if (stack.isEmpty() || stack.pop() != '{') {

                        return false;
                    }
                    continue;
                case ')' :
                    if (stack.isEmpty() || stack.pop() != '(') {

                        return false;
                    }
                    continue;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        ValidBrackets validBrackets = new ValidBrackets();
        boolean result = validBrackets.isValid("()");
        System.out.println(result);
    }
}
