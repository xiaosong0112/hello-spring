package geektime.spring.demo.hellospring.algorithm.string;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * 判断字符串1的其中一个排列是否是字符串2中的一个子字符串
 */
public class Permutation {

    /**
     * 判断是s1的字符串是否在s2当中.
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean permutation(String s1, String s2) {

        // 因为数组定义需要具体的数量，不能自动扩容，所以定义list来转数组.
        LinkedList<String> linkedList = new LinkedList<>();

        // 定义s1的返回结果集合
        String[] permutations = (String[]) linkedList.toArray(new String[linkedList.size()]);

        char[] chars = s1.toCharArray();

        // 去重减枝用的
        HashSet<Character> set = new HashSet<>();

        // 求s1字符串的全排列子字符串,因为涉及到可能有重复的字符，所以在深度遍历的过程中需要进行减枝操作。
        dfs(0, chars, set, linkedList);

        // 遍历所有可能得s1的组合,只要有一个组合被s2字符串包含，则返回true
        for (String string : linkedList) {

            if (s2.contains(string)) {

                return true;
            }
        }

        // 一个组合都没有包含，返回false
        return false;
    }

    private void dfs(int x, char[] chars, HashSet<Character> set, LinkedList<String> linkedList) {

        if (x == linkedList.size() - 1) {

            linkedList.add(String.valueOf(chars));
        }

        for (int i = 0; i < chars.length; i++) {

            if (set.contains(chars[i])) {

                continue;
            }

            swap(chars[i], chars[x]);
            dfs(x, chars, set, linkedList);
            swap(chars[i], chars[x]);
        }
    }

    /**
     * 交换两个元素
     * @param a
     * @param b
     */
    private void swap(char a, char b) {


    }

}
