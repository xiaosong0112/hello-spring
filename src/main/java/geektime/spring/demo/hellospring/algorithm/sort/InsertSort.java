package geektime.spring.demo.hellospring.algorithm.sort;

/**
 * 插入排序（这个插入排序是错的。只需要一次赋值就可以了。）
 */
public class InsertSort {

    public void insertSort(int[] nums) {

        // 校验数组元素 如果数组元素的数量没有或者只有一个，那么该数组不用进行排序。
        if (nums.length < 2) {

            return;
        }

        for (int i = 1; i < nums.length;i++) {

            int preIndex = i - 1;
            int currentIndex = i;

            while(currentIndex > 0 && nums[currentIndex] < nums[preIndex]) {

                swapReferences(nums, preIndex ,currentIndex);
                currentIndex--;
                preIndex--;
            }
        }
    }

    public void swapReferences(int[] nums, int left, int right) {

        int temp = nums[left];
        nums[left]= nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {

        int[] nums = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        InsertSort insertSort = new InsertSort();
        insertSort.insertSort(nums);

        for (int number : nums) {

            System.out.println(number);
        }
    }
}
