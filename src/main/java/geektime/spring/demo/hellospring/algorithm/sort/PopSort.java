package geektime.spring.demo.hellospring.algorithm.sort;

/**
 * https://blog.csdn.net/xiaoxiaojie12321/article/details/81380834
 * 排序原理讲解
 */
public class PopSort {

    public int[] popSort(int[] nums) {

        // 校验元素是否为空
        if (nums.length < 2) {

            return nums;
        }

        // 最外层循环代表循环次数。
        for (int i = 0; i < nums.length - 1; i++) {

            // 内层循环代表每一次比较相邻的两个数字。因为第一次完成之后一定会产生最大的一个数字在最右侧，所以下次比较就可以少比较一次。
            for(int j = 0; j < nums.length - 1 - i; j++) {

                if (nums[j] > nums[j+1]) {

                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }

        return nums;
    }

    public static void main(String[] args) {

        int[] nums = {9,8,7,6,5,4,3,2,1};

        PopSort popSort = new PopSort();

        int[] result = popSort.popSort(nums);

        for (int number : result) {

            System.out.println(number);
        }
    }
}
