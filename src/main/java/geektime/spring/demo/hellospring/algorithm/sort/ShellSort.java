package geektime.spring.demo.hellospring.algorithm.sort;

/**
 * https://www.jianshu.com/p/8944400512b0 重点看举例过程
 */
public class ShellSort {

    public void shellSort(int[] nums) {

        // 设置步长
        int step = nums.length / 2;

        // 循环里面一定要是等于1，不然无法进行最后一次循环。
        while(step >= 1) {

            for (int i = step; i < nums.length; i++) {

                // 保存数组中第i个位置的元素的值
                int temp = nums[i];

                // 保存间隔之前的那个数字的值
                int j = i - step;

                while (j >= 0 && nums[j] < temp) {

                    // 把比较大的j上的值交换到i上。
                    nums[j + step] = nums[j];

                    nums[j] = temp;

                    // 为了跳出循环
                    j = j - step;
                }
            }

            step = step / 2;
        }

    }

    public static void main(String[] args) {

        int[] nums = {6,1,2,7,9,3,5,4,10,8};

        ShellSort shellSort = new ShellSort();
        shellSort.shellSort(nums);

        for (int number : nums) {

            System.out.println(number);
        }
    }
}
