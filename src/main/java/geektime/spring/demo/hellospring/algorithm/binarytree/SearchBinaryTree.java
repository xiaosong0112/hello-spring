package geektime.spring.demo.hellospring.algorithm.binarytree;

import geektime.spring.demo.hellospring.algorithm.definition.TreeNode;

/**
 * 搜索二叉树中存在的值
 */
public class SearchBinaryTree {

    public TreeNode BFT(TreeNode root, int val) {

        if (root == null) {

            return null;
        }

        if (root.val == val) {

            return root;
        }

        // 根据二叉树的特性判断这个值在树的左子树上还是右子树上。
        if (val < root.left.val) {

            return BFT(root.left, val);
        }

        if (val > root.right.val) {

            return BFT(root.right, val);
        }

        return root;
    }
}