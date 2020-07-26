package geektime.spring.demo.hellospring.algorithm.sort;

/**
 * 快速排序原理过程讲解
 * https://www.cnblogs.com/lanhaicode/p/10348906.html（举例非常容易理解）
 * https://blog.csdn.net/qq_36186690/article/details/82470451  代码是对的。
 */
public class FastSort {

    public int[] fastSort(int[] nums) {

        fastSort(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 快速排序分片
     * @param nums
     * @param low
     * @param high
     * @return
     */
    public void fastSort(int[] nums, int low, int high) {

        // 最后添加校验防止while无线循环
        if(low >= high) {
            return;
        }

        // 保存基准数的值
        int pivot = nums[low];

        // 不改变low和high的下标，对left和right做指针偏移的操作。
        int left = low;
        int right = high;

        // 当指针left在right左边的时候进行指针偏移操作。
        while (left < right) {

            // 右侧指针指向的数字比基准数的值大的时候继续偏移，直到遇到第一个比基准数小的值停止循环。
            while (left < right && pivot <= nums[right]) {

                right--;
            }

            // 左侧指针指向的数字比基准数的值小的时候继续偏移，直到遇到第一个比基准数大的值停止循环。
            while (left < right && nums[left] <= pivot) {

                left++;
            }

            // 都停止循环之后，交换两个数字所在的位置。
            swapReferences(nums, left, right);
        }

        // 当左侧和右侧的指针重合或者交错过彼此的位置之后
        // 将左侧指针指向的数字和基准数的位置进行交换。
        // 也就是把指针指向的数字放在原来数组的最左侧位置
        nums[low] = nums[left];

        // 把这次的基准数放在中间位置。
        nums[left] = pivot;

        fastSort(nums, low, left - 1);
        fastSort(nums, right + 1, high);

    }

    public void swapReferences(int[] nums, int left, int right) {

        if (left < right) {

            int temp = nums[left];
            nums[left]= nums[right];
            nums[right] = temp;
        }
    }

    public static void main(String[] args) {

        int[] nums = {6,1,2,7,9,3,5,4,10,8};

        FastSort fastSort = new FastSort();

        fastSort.fastSort(nums);

        for (int number : nums) {

            System.out.println(number);
        }

    }


}
