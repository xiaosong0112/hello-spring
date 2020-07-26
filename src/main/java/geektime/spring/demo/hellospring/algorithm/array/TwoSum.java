package geektime.spring.demo.hellospring.algorithm.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap();

        for(int i = 0; i < nums.length; i++) {

            hashMap.put(nums[i],i);
        }

        for(int i = 0; i < nums.length; i++) {

            int cop = target - nums[i];
            if (hashMap.containsKey(cop) && hashMap.get(cop) != i) {

                return new int[] {i, hashMap.get(cop)};
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {

        int[] test = new int[] {2,3,5,9};
        int target = 14;

    }
}
