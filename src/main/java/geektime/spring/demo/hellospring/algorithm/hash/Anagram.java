package geektime.spring.demo.hellospring.algorithm.hash;

import java.util.Arrays;

/**
 * 有效的字母异位词 leecode 242
 */
public class Anagram {

    /**
     * char数组字典排序
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    /**
     * 只考虑英文的情况
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {

        // 校验参数
        if (s == null || t == null) {

            return false;
        }

        if (s.length() != t.length()) {

            return false;
        }

        // 初始化计数的数组
        int[] counter = new int[26];

        for (int i = 0; i < s.length(); i++) {

            // s的每个字母负责在对应的位置计数上+1
            counter[s.charAt(i) - 'a']++;
            // t的每个字母负责在对应的位置计数上-1
            counter[t.charAt(i) - 'a']--;
        }

        for(int number : counter) {

            if (number != 0) {

                return false;
            }
        }

        return true;
    }
}
