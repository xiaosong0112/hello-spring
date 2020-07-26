package geektime.spring.demo.hellospring.algorithm.string;

/**
 * 最长公共字符串
 */
public class CommonPrefixString {

    public String commonPrefixString(String[] strings) {

        // 如果数组的长度为0 则直接返回公共前缀的长度为0
        if (strings.length == 0) {

            return "";
        }

        // 用string1当做默认的公共前缀进行比较
        String res = strings[0];

        for (int i = 1; i < strings.length; i++) {

            String temp = strings[i];

            int j = 0;
            for (;j < temp.length();j++) {

                if (res.charAt(j) != strings[i].charAt(j)) {

                    break;
                }
            }
            res = res.substring(0, j);

            if (res.equals("") || res.length() == 0) {

                return res;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        String[] strings = new String[3];
        strings[0] = "flower";
        strings[1] = "flowee";
        strings[2] = "floaaa";

        CommonPrefixString commonPrefixString = new CommonPrefixString();
        String result = commonPrefixString.commonPrefixString(strings);
        System.out.println(result);
    }
}
