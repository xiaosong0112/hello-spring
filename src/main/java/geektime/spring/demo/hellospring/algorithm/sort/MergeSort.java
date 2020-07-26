package geektime.spring.demo.hellospring.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序
 * https://time.geekbang.org/column/article/79048
 */
public class MergeSort {

    public int[] mergeSort(int[] nums) {

        // 空数组不进行处理
        if (nums.length == 0) {

            return nums;
        }

        // 2路归并，分解到不能够再分解的1个元素的数组的时候就准备开始进行合并操作。
        if (nums.length < 2) {

            return nums;
        }

        // 求二分的位置
        int mid = nums.length / 2;

        // 分别拷贝左右两部分的内容生成2个新数组。
        int[] left = Arrays.copyOfRange(nums,0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, nums.length);

        // 递归调用左边和右边
        left = mergeSort(left);
        right = mergeSort(right);

        // 合并数据
        int[] result = merge(left, right);
        return result;
    }

    private int[] merge(int[] left, int[] right) {

        if (left == null || left.length == 0) {

            return new int[0];
        }

        if (right == null || right.length == 0) {

            return new int[0];
        }

        int totalIndex = 0;

        int[] totalArray = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;

        while(leftIndex < left.length && rightIndex < right.length) {

            if (left[leftIndex] > right[rightIndex]) {

                totalArray[totalIndex] = right[rightIndex];
                rightIndex++;
            } else {

                totalArray[totalIndex] = left[leftIndex];
                leftIndex++;
            }

            totalIndex++;
        }

        if (leftIndex < left.length) {

            for (int number = leftIndex; number < left.length; number++) {

                totalArray[totalIndex] = left[number];
                totalIndex++;
            }
        } else {

            for (int number = rightIndex; number < right.length; number++) {

                totalArray[totalIndex] = right[number];
                totalIndex++;
            }
        }

        return totalArray;
    }

    public static void main(String[] args) {

        int[] nums = {6,1,2,7,9,3,5,4,10,8};

        MergeSort mergeSort = new MergeSort();
        int[] results = mergeSort.mergeSort(nums);

        for (int result : results) {

            System.out.println(result);
        }
    }
}
