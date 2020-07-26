package geektime.spring.demo.hellospring.algorithm.string;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 复原ip地址
 */
public class RestoreIpAddresses {

    public List<String> restoreIpAddresses(String s) {

        List<String> res = partition(s, 4);

        // 这个是用来处理最后拼接完毕后字符串最后多出来的 "."。 guava循环处理list中的字符串对每个元素去除后再重新拼接。
        return res.stream().map(s1 -> s1.substring(0, s1.length() - 1)).collect(Collectors.toList());
    }

    /**
     * count代表需要得到几组数字. s代表参数字符串
     * @param s
     * @param count
     * @return
     */
    private List<String> partition(String s, int count) {

        List<String> res = new ArrayList<>();
        if (s.isEmpty() && count == 0) {
            res.add("");
            return res;
        }

        // ip地址最多可选择三位，最少可选择一位
        if (count > s.length() || count < s.length() / 3) {
            return res;
        }

        for (int i = 0; i < 3 && i < s.length(); i++) {

            if (!isValidIp(s.substring(0, i + 1))) {
                continue;
            }

            List<String> temp = partition(s.substring(i + 1), count - 1);

            for (String right : temp) {
                res.add(s.substring(0, i + 1) + "." + right);
            }
        }

        return res;
    }

    /**
     * 验证ip是否有效
     * @param s
     * @return
     */
    private boolean isValidIp(String s) {

        // 这个写的眼前一亮 就是想说，只有相等的返回true。不相等的以0开头的都是false。
        if (s.startsWith("0")) {
            return s.equals("0");
        }
        int ip = Integer.parseInt(s);
        return ip >= 0 && ip <= 255;
    }

    public static void main(String[] args) {

        String param = "25525511135";

        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
        List<String> results = restoreIpAddresses.restoreIpAddresses(param);

        for(String result : results) {

            System.out.println(result);
        }
    }
}
