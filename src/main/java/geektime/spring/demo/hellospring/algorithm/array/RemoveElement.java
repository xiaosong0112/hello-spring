package geektime.spring.demo.hellospring.algorithm.array;

/**
 * 标签：交换移除
 * 主要思路是遍历数组nums，遍历指针为i，总长度为ans
 * 在遍历过程中如果出现数字与需要移除的值不相同时，则i自增1，继续下一次遍历
 * 如果相同的时候，则将nums[i]与nums[ans-1]交换，即当前数字和数组最后一个数字进行交换，交换后就少了一个元素，故而ans自减1
 * 这种思路在移除元素较少时更适合使用，最极端的情况是没有元素需要移除，遍历一遍结束即可
 * 时间复杂度：O(n)，空间复杂度：O(1)
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {

        // 验证参数边界
        if (nums.length < 1) {

            return nums.length;
        }

        int i = 0;
        int length = nums.length;

        // 对数组进行循环
        loop1 :
        for (i = 0; i < length;) {

            if (nums[i] == val) {

                nums[i] = nums[length - 1];
                length--;
            } else {
                i++;
            }
        }

        return i;
    }

    public static void main(String[] args) {

        int[] nums = {0,1,2,2,3,0,4,2};
        RemoveElement removeElement = new RemoveElement();
        int result = removeElement.removeElement(nums, 2);
        System.out.println(result);
    }
}
