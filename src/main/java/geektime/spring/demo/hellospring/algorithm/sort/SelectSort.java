package geektime.spring.demo.hellospring.algorithm.sort;

public class SelectSort {

    public int[] selectSort(int[] nums) {

        if (nums == null) {

            return nums;
        }

        int length = nums.length;

        if (length < 2) {

            return nums;
        }

        for (int i = 0; i < length - 1; i++) {

            // 记录最小值得为之
            int min = i;
            int j = i + 1;
            for (; j < length;j++) {

                // 比较每一个数字
                if (nums[j] < nums[i]) {
                    min = j;
                }
            }

            if (min != i) {

                int temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;
            }
        }

        return nums;
    }

    public static void main(String[] args) {

        int[] nums = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        SelectSort selectSort = new SelectSort();
        int[] result = selectSort.selectSort(nums);
    }
}
