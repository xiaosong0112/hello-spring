package geektime.spring.demo.hellospring.algorithm.binarytree;

import geektime.spring.demo.hellospring.algorithm.definition.TreeNode;

/**
 * 二叉搜索树范围和(注意这是个二叉搜索树，不是普通二叉树)
 */
public class RangeSumBST {

    public int rangeSumBST(TreeNode root, int L, int R) {

        // 思路就是判断节点L和R
        if (root.val < L) {

            return rangeSumBST(root.right, L, R);
        }

        if (root.val > R) {

            return rangeSumBST(root.left, L, R);
        }

        return root.val + rangeSumBST(root.right, L, R) + rangeSumBST(root.left, L, R);
    }
}
