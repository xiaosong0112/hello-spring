package geektime.spring.demo.hellospring.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        if (nums == null || nums.length == 0) {

            return new ArrayList<>();
        }

        if (nums.length < 3) {

            return new ArrayList<>();
        }

        List<List<Integer>> resultList = new ArrayList<>();

        // 先对数组进行排序
        Arrays.sort(nums);

        // 循环数组
        for (int number1Index = 0; number1Index < nums.length; number1Index++) {

            if (nums[number1Index] > 0) {

                break;
            }

            if(number1Index > 0 && nums[number1Index] == nums[number1Index-1]) {

                continue;
            }

            // 定义数字对应的指针位置
            int number2Index = number1Index + 1;
            int number3Index = nums.length - 1;

            while (number3Index > number2Index) {

                if (nums[number1Index] + nums[number2Index] + nums[number3Index] == 0) {

                    List<Integer> subResultList = new ArrayList<>();

                    subResultList.add(nums[number1Index]);
                    subResultList.add(nums[number2Index]);
                    subResultList.add(nums[number3Index]);

                    resultList.add(subResultList);

                    while (number2Index < number3Index && nums[number2Index] == nums[number2Index+1]) number2Index++; // 去重
                    while (number2Index < number3Index && nums[number3Index] == nums[number3Index-1]) number3Index--; // 去重

                    number3Index--;
                    number2Index++;

                } else if (nums[number1Index] + nums[number2Index] + nums[number3Index] > 0) {

                    number3Index--;
                } else if (nums[number1Index] + nums[number2Index] + nums[number3Index] < 0) {

                    number2Index++;
                }

            }
        }

        return resultList;
    }

    public static void main(String[] args) {

        int[] nums = {-1,0,1,2,-1,-4};

        ThreeSum threeSum = new ThreeSum();

        List<List<Integer>> result = threeSum.threeSum(nums);
        System.out.println(result);
    }
}
