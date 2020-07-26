package geektime.spring.demo.hellospring.algorithm.string;

/**
 * 验证一个字符串是否是回文字符串
 */
public class IsPalindrome {

    public boolean isPalindrome(String s) {

        // 判断奇数偶数
        // 如果是奇数 寻找中位数，然后截取两边的内容。将其中一侧的字符串进行反转并且处理字符的大小写和空格后拼接起来。
        // 如果是偶数 寻找中位数，然后平均截取两段，将一段反转。

        // 空字符串直接就是回文字符串直接返回。
        if (s == null || s.length() == 0) {

            return true;
        }

        int length = s.length();

        // 如果是偶数
        if (length % 2 == 0) {

            String left = s.substring(0, (length / 2));
            String right = s.substring(length / 2, length);

            return isPalindrome(left, right);
        } else {

            String left = s.substring(0, (length / 2));
            String right = s.substring(length / 2 + 1, length);

            return isPalindrome(left, right);
        }
    }

    private boolean isPalindrome(String left, String right) {

        String newRight = getNewRight(right);

        if (left.equals(newRight.toLowerCase().trim())) {

            return true;
        } else {

            return false;
        }
    }

    private String getNewRight(String right) {

        char[] chars = new char[right.length()];

        // 反转字符串right并对每个字符串进行大小写和空格处理
        for (int i = 0; i < right.length(); i++) {

            char temp = right.charAt(i);

            // 处理空格
            if (String.valueOf(temp).trim().equals("")) {
                continue;
            }

            // 倒叙赋值
            chars[right.length()- 1 - i] = right.charAt(i);
        }

        return String.valueOf(chars);
    }

    public static void main(String[] args) {

        IsPalindrome isPalindrome = new IsPalindrome();
        boolean result = isPalindrome.isPalindrome("aabbaa");
        System.out.println(result);
    }
}
