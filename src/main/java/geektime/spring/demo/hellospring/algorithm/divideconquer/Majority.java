package geektime.spring.demo.hellospring.algorithm.divideconquer;

import java.util.Arrays;
import java.util.HashMap;

/**
 * leecode
 */
public class Majority {

    // 思路1 暴力比较法 O(n2)
    // 思路2 map统计比较法 O(n)
    // 思路3 排序后统计 重复的元素个数最多的 O(logn)
    // 思路4 分支

    public static void main(String[] args) {

        int[] test = new int[] {1,2,4,4,3,3,4,4};

        // 使用暴力破解法
        Majority majority = new Majority();
        int result1 = majority.forceDone(test);
        System.out.println(result1);

        int result2 = majority.mapCount(test);
        System.out.println(result2);

        int result3 = majority.sortCount(test);
        System.out.println(result3);
    }

    /**
     * 方法1 暴力破解法
     * @param numbers
     * @return
     */
    public int forceDone(int[] numbers) {

        int length = numbers.length;

        if (length <= 2) {

            return 0;
        }

        int half = this.getHalf(length);

        for (int i = 0; i < numbers.length; i++) {

            int count = 0;
            for (int j = 0;j < numbers.length; j++) {

                if (numbers[i] == numbers[j]) {

                    count++;
                }

                if (count > half) {

                    return numbers[i];
                }
            }
        }

        return 0;
    }

    private int getHalf(int length) {

        int half = 0;

        // 判断length是奇数还是偶数
        if (length % 2 == 0) {

            half = length / 2;
        } else {

            half = (length - 1) / 2;
        }
        return half;
    }

    /**
     * 使用map计数的方法
     * @return
     */
    public int mapCount(int[] numbers) {

        HashMap<Integer, Integer> numberCountMap = new HashMap<>();

        int length = numbers.length;

        if (length <= 2) {

            return 0;
        }

        int half = this.getHalf(length);

        for (int i = 0; i < length;i++) {

            if (numberCountMap.containsKey(numbers[i])) {

                int count = numberCountMap.get(numbers[i]);
                count++;
                numberCountMap.put(numbers[i], count);

                if (count > half) {

                    return numbers[i];
                }
            } else {

                numberCountMap.put(numbers[i], 1);
            }
        }

        return 0;
    }

    /**
     * 排序统计
     * @return
     */
    public int sortCount(int[] numbers) {

        int length = numbers.length;

        if (length <= 2) {

            return 0;
        }

        Arrays.sort(numbers);

        int half = this.getHalf(length);

        // 记录前一个数字
        int preNumber = 0;
        int currentNumber = 0;
        int count = 1;
        for (int i = 1; i < numbers.length; i++) {

            preNumber = numbers[i - 1];
                currentNumber = numbers[i];
            if (preNumber == currentNumber) {

                count++;
            } else {
                count = 1;
            }

            if (count > half) {

                return currentNumber;
            }
        }

        return 0;
    }

    /**
     * 网友最牛答案
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

//    /**
//     * 摩尔投票法
//     * @return
//     */
//    public int moleVote(int[] numbers) {
//
//
//    }
}
