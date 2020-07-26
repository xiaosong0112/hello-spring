package geektime.spring.demo.hellospring.algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复的最长字符串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-jie-suan-fa-3-wu-zhong-fu-zi-fu-de-zui-chang-z/
 * 画图解法真的很清晰
 */
public class NoRepeatSubString {

    /**
     * 第二种解法就是以字符串每个字母为起始，判断由它开始的字符串最长多长无重复
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        // 字符串的长度
        int n = s.length();

        // 定义返回结果 用于更新。
        int ans = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int end = 0, start = 0; end < n; end++) {

            char alpha = s.charAt(end);

            if (map.containsKey(alpha)) {

                start = Math.max(map.get(alpha), start);
            }

            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }

    /**
     * 注释
     * @param s
     * @return
     */
    public  int lengthOfLongestSubstring03(String s) {
        int n = s.length(), ans = 0;
        //创建map窗口,i为左区间，j为右区间，右边界移动
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < n; j++) {
            // 如果窗口中包含当前字符，
            if (map.containsKey(s.charAt(j))) {
                //左边界移动到 相同字符的下一个位置和i当前位置中更靠右的位置，这样是为了防止i向左移动
                i = Math.max(map.get(s.charAt(j)), i);
            }
            //比对当前无重复字段长度和储存的长度，选最大值并替换
            //j-i+1是因为此时i,j索引仍处于不重复的位置，j还没有向后移动，取的[i,j]长度
            ans = Math.max(ans, j - i + 1);
            // 将当前字符为key，下一个索引为value放入map中
            // value为j+1是为了当出现重复字符时，i直接跳到上个相同字符的下一个位置，if中取值就不用+1了
            map.put(s.charAt(j), j+1);
        }
        return ans;
    }

}
