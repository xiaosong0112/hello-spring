package geektime.spring.demo.hellospring.algorithm.string;

import java.util.HashSet;

public class NoRepeatSubStrings {

    public int getMaxLength(String str) {

        if (str == null || str.length() == 0) {

            return 0;
        }

        char[] chars = str.toCharArray();

        // 用于保存字符，判断字符是否重复
        HashSet<Character> set = new HashSet<>();
        set.add(chars[0]);

        int maxLength = 0;

        //  双指针移动
        for (int start = 0, end = start + 1; end < str.length(); end++) {

            // 判断字符串是否重复
            if (!set.contains(chars[end])) {

                set.add(chars[end]);
            } else {

                // 如果重复了重置双指针的位置，把start移动到当前end之后。
                start = Math.max(start, end + 1);
            }

            // 不管怎么每一次都计算最长的长度是多少。
            maxLength = Math.max(maxLength, str.substring(start, end + 1).length());
        }

        return maxLength;
    }
}
