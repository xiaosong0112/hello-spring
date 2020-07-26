package geektime.spring.demo.hellospring.algorithm.sort;

public class InsertSort2 {

    public int[] insertSort(int[] nums) {

        int length = nums.length;

        if (length < 2) {

            return nums;
        }

        // i 代表动的数字 j代表被比较的数字
        for(int i = 1; i < length; i++) {

            int value = nums[i];
            int j = i - 1;

            // j代表排好序的数字
            for (; j >= 0; j--) {

                // 如果被比较的数字i比当前的有序数列中的数字j小。就把j的位置往右挪动。
                if (nums[j] > value) {

                    nums[j + 1]=nums[j];
                } else {

                    // 如果被比较的动态数字i 比有序数列中的数字j大了。
                    break;
                }
            }

            nums[j + 1] = value;
        }

        return nums;
    }

    public static void main(String[] args) {

        int[] nums = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        InsertSort2 insertSort2 = new InsertSort2();
        insertSort2.insertSort(nums);
        for (int number : nums) {
            System.out.println(number);
        }
    }
}
