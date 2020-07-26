package geektime.spring.demo.hellospring.algorithm.array;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class FindMiddleNumbers {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // 校验数组元素m和数组n 如果同时为空，则返回0，默认为空数
        if (nums1.length < 1 && nums2.length < 1) {

            return 0d;
        }

        // 合并数组
        int[] arrays = new int[nums1.length + nums2.length];

        for (int i = 0; i < nums1.length; i++) {

            arrays[i] = nums1[i];
        }

        for (int i = 0; i < nums2.length; i++) {

            arrays[nums1.length + i] = nums2[i];
        }

        Arrays.sort(arrays);

        // 后寻找中位数
        BigDecimal length = new BigDecimal(nums1.length);
        BigDecimal two = new BigDecimal(2);
        BigDecimal middle = length.divide(two, 0, RoundingMode.HALF_UP);
        int middleIndex = middle.intValue();

        // 判断数组1的元素有奇数个还是偶数个
        if (arrays.length % 2 == 0) {

            BigDecimal middle1 = new BigDecimal(arrays[middleIndex - 1]);
            BigDecimal middle2 = new BigDecimal(arrays[middleIndex]);
            return middle1.add(middle2).divide(two, 1, RoundingMode.HALF_UP).doubleValue();
        } else {

            return arrays[middleIndex];
        }
    }

    public static void main(String[] args) {

        FindMiddleNumbers findMiddleNumbers = new FindMiddleNumbers();
        int[] nums1 = {3,4};
        int[] nums2 = {};
        double result = findMiddleNumbers.findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }
}
