package geektime.spring.demo.hellospring.algorithm.string;

/**
 * 乘法
 * https://leetcode-cn.com/problems/multiply-strings/solution/you-hua-ban-shu-shi-da-bai-994-by-breezean/
 */
public class StringMultiply {

    public String multiply(String number1, String number2) {

        if (number1.equals("0") || number2.equals("0")) {

            return "0";
        }

        int length1 = number1.length();
        int length2 = number2.length();

        String result = "0";

        // 从第二个数字的最后一位开始从右边往左边进行遍历
        for (int j = length2 - 1; j >= 0 ;j--) {

            // 定义相乘运算的定位，初始值为0;
            int carry = 0;

            // 保存相乘运算的结果集
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < length2 - 1 - j; i++) {

                // 因为是从左边开始补0，然后往右边移动。
                stringBuilder.append(0);
            }

            // 数字二的当前位
            int n2 = number2.charAt(j) - '0';

            // 从右往左遍历，把第一个数字的每个位分别与第二个数相乘。
            for (int i = length1 - 1; i >= 0 || carry != 0; i--) {

                // 数字1的当前位
                int n1 = i < 0 ? 0 : number1.charAt(i) - '0';

                // 余数
                int remainder = (n1 * n2 + carry) % 10;

                // 将运算后的确定的数字也就是余数添加到字符串中。
                stringBuilder.append(remainder);

                // 计算运算后进位是多少
                carry = (n1 * n2 + carry) / 10;
            }

            // 每次运算后的字符串再进行相加的操作，依旧只能按位运算，不能直接用int相加。
            result = addResult(result, stringBuilder.reverse().toString());
        }

        return result;
    }

    /**
     * 每次两个位运算后，对结果进行字符串相加
     * @param string1
     * @param string2
     * @return
     */
    private String addResult(String string1, String string2) {

        // 保存相加运算的结果集
        StringBuilder stringBuilder = new StringBuilder();

        int length1 = string1.length();
        int length2 = string2.length();

        // 定义相加运算的进位
        int carry = 0;

        // 同步对两个字符串进行循环操作
        for (int i = length1 - 1, j = length2 - 1; i >= 0 || j >= 0 || carry != 0; i--, j--) {

            // 遍历位数
            int x = i < 0 ? 0 : string1.charAt(i) - '0';
            int y = j < 0 ? 0 : string2.charAt(j) - '0';

            // 余数
            int remainder = (x + y + carry) % 10;
            stringBuilder.append(remainder);

            // 进位数
            carry = (x + y + carry) / 10;
        }


        return stringBuilder.reverse().toString();
    }

    /**
     * https://leetcode-cn.com/problems/multiply-strings/solution/you-hua-ban-shu-shi-da-bai-994-by-breezean/
     * 进阶版字符串相加
     * @return
     */
    public String plusStringMultiply(String number1, String number2) {

        if (number1.equals("0") || number2.equals("0")) {

            return "0";
        }

        // 两个数字相乘最后的结果长度为 number1的长度 + number2的长度。（数组中放置数字的顺序是 0放置个位，1放置10位这样依次类推）
        int[] result = new int[number1.length() + number2.length()];

        // 从右往左遍历第二个数字
        for (int j = number2.length() - 1; j >=0 ; j--) {

            int n2 = number2.charAt(j) - '0';

            for (int i = number1.length() - 1; i >= 0; i--) {

                int n1 = number1.charAt(i) - '0';

                // 先结算上次的进位，求出来和。
                int sum = result[i + j + 1] + (n1 * n2);

                // result[i + j + 1] 代表余数的位置（而低位不用）
                result[i + j + 1] = sum % 10;

                // 高位的是进位的数字（进的位数需要每次进行累加）
                result[i + j] = result[i + j] + sum / 10;
            }
        }

        return this.getStringResult(result);
    }

    /**
     * 将数组中的位转化成字符串
     * @param result
     * @return
     */
    private String getStringResult(int[] result) {

        if (result == null || result.length == 0) {

            return "";
        }

        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < result.length; i++) {

            if (i == 0 && result[i] == 0) {

                // 第一位也就是最高位可能为0，所以不在最后结果的字符串上进行添加 比如 056088中的第一位数字0
                continue;
            }
            stringBuffer.append(result[i]);
        }

        return stringBuffer.toString();
    }

    public static void main(String[] args) {

        String string1 = "123";
        String string2 = "456";

        StringMultiply stringMultiply = new StringMultiply();
        String result = stringMultiply.multiply(string1, string2);

        System.out.println(result);


        String result2 = stringMultiply.plusStringMultiply(string1, string2);
        System.out.println(result2);
    }
}
