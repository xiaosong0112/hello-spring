package geektime.spring.demo.hellospring.algorithm.binarytree;

import geektime.spring.demo.hellospring.algorithm.definition.TreeNode;

import java.util.Arrays;

/**
 * 将有序数组转换为二叉搜索树
 */
public class SortedArrayToBST {

    /**
     * 思路是二分法
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums == null || nums.length == 0) {

            return null;
        }

        int middle = nums.length / 2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, middle));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, middle + 1, nums.length));
        return root;
    }
}
