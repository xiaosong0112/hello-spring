package geektime.spring.demo.hellospring.practise;

import java.util.HashMap;

public class LongestNoRepeatSubString {

   public int lengthOfLongestSubstring(String s) {

       // 双指针移动 当出现重复的字符的时候移动start指针 重新开始计数
       if (s == null || s.length() == 0) {

           return 0;
       }

       int maxLength = 0;

       // 存放字符和指向的下个位置的索引。为了下次循环的时候进行判断使用.
       HashMap<Character, Integer> hashMap = new HashMap<>();

       for (int start = 0, end = 0; end < s.length(); end++) {

            if (hashMap.containsKey(s.charAt(end))) {

                start = Math.max(start, hashMap.get(s.charAt(end)));
            }

            maxLength = Math.max(maxLength, end - start + 1);
            hashMap.put(s.charAt(end), end + 1);
       }

       return maxLength;
    }
}
