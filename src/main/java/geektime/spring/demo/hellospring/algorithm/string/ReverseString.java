package geektime.spring.demo.hellospring.algorithm.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 反转字符串中的元音字母
 */
public class ReverseString {

    /**
     * 思路一 用栈进行反转
     * @param param
     * @return
     */
    public String reverseString(String param) {

        if (param == null || param.length() == 0) {

            return null;
        }

        List<Character> vowels = getVowels();
        Stack stack = new Stack();

        char[] chars = param.toCharArray();

        for (int i = 0; i < chars.length; i++) {

            if (vowels.contains(chars[i])) {

                stack.push(chars[i]);
            }
        }

        for (int i = 0; i < chars.length; i++) {

            if (vowels.contains(chars[i])) {

                chars[i] = (char) stack.pop();
            }
        }

        return String.valueOf(chars);
    }

    /**
     * 思路二
     * @param param
     * @return
     */
    public String reverseString2(String param) {

        if (param == null || param.length() == 0) {

            return "";
        }

        char[] chars = param.toCharArray();

        int start = 0;
        int end = chars.length - 1;

        List<Character> vowels = this.getVowels();

        while(start < end) {

            if (!vowels.contains(chars[start])) {
                start++;
                continue;
            }

            if (!vowels.contains(chars[end])) {

                end--;
                continue;
            }

            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }

        return String.valueOf(chars);
    }

    private List<Character> getVowels() {

        List<Character> vivel = new ArrayList<>();
        vivel.add('a');
        vivel.add('e');
        vivel.add('i');
        vivel.add('o');
        vivel.add('u');
        vivel.add('A');
        vivel.add('E');
        vivel.add('I');
        vivel.add('O');
        vivel.add('U');
        return vivel;
    }

    public static void main(String[] args) {

        ReverseString reverseString = new ReverseString();
        String result = reverseString.reverseString2("leetcode");

        System.out.println(result);
    }
}
