package geektime.spring.demo.hellospring.algorithm.binarytree;

import geektime.spring.demo.hellospring.algorithm.definition.TreeNode;

/**
 * 翻转二叉树
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {

        if (root == null) {

            return null;
        }

        swapNode(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    private void swapNode(TreeNode root) {

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
