package geektime.spring.demo.hellospring.algorithm.array;

/**
 * 删除有序数组中的重复项
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {

        if (nums == null) {

            return 0;
        }

        if (nums.length < 2) {

            return 1;
        }

        // 设置相邻的两个指针
        int p = 0;
        int q = p + 1;

        while (q < nums.length) {

            if (nums[p] >= nums[q]) {

                q++;
            } else {
                nums[p + 1] = nums[q];
                p++;
                q = p + 1;
            }
        }

        return p + 1;
    }

    public static void main(String[] args) {

        int[] test = {0,0,1,1,1,2,2,3,3,4};
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int result = removeDuplicates.removeDuplicates(test);

        System.out.println(result);
    }
}
