package geektime.spring.demo.hellospring.practise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 最长的回文字符串
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {

        // 切分字符串找出回文字符串的组合。
        // 子字符串是否是回文字符串。
        // 回文字符串的最长的长度。
        if (s == null || s.length() <= 1) {

            return s;
        }

        if(isPalindrome(s)) {

            return s;
        }

        List<String> resultList = new ArrayList<>();

        // 遍历字符串，判断每个可能的子字符串是否是回文字符串，如果是回文字符串则计算长度。

        for (int start = 0; start < s.length(); start++) {

            for(int end = start + 1; end <= s.length(); end++) {

                String subString = s.substring(start, end);

                boolean result = isPalindrome(subString);

                if (result) {

                    resultList.add(subString);
                }
            }
        }

        // 遍历result
        int maxLength = 0;
        HashMap<Integer, String> hashMap = new HashMap<>();

        for (int i = 0; i < resultList.size(); i++) {

            String result = resultList.get(i);
            if (result.length() > maxLength) {

                hashMap.clear();
                maxLength = result.length();
                hashMap.put(maxLength, result);
            }
        }

        return hashMap.get(maxLength);
    }

    private boolean isPalindrome(String subString) {

        // 如果是奇数
        if ((subString.length() & 1) == 1) {

            String left = subString.substring(0, subString.length() / 2);
            String right = subString.substring(subString.length() / 2 + 1, subString.length());

            return isPalindrome(left, right);
        } else {

            String left = subString.substring(0, subString.length() / 2);
            String right = subString.substring(subString.length() / 2, subString.length());
            return isPalindrome(left, right);
        }
    }

    private boolean isPalindrome(String left, String right) {

        String reverseResult = reverseRight(right);

        if (left.equals(reverseResult)) {

            return true;
        } else {

            return false;
        }
    }

    /**
     * 反转字符串
     * @param right
     * @return
     */
    private String reverseRight(String right) {

        char[] chars = right.toCharArray();
        char[] result = new char[chars.length];

        for (int i = 0; i < chars.length; i++) {

            if (String.valueOf(chars[i]).trim().equals("")) {

                continue;
            }

            result[chars.length - i - 1] = chars[i];
        }

        return String.valueOf(result);
    }

    public static void main(String[] args) {

        String param = "cabbbba";

        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String result = longestPalindrome.longestPalindrome(param);

        System.out.println(result);
    }
}
