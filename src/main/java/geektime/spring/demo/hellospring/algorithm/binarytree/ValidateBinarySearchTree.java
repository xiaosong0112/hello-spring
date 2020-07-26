package geektime.spring.demo.hellospring.algorithm.binarytree;

import geektime.spring.demo.hellospring.algorithm.definition.TreeNode;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {

        return validateBST1(root, root.left.val, root.right.val);
    }

    /**
     * 递归的解法
     * @param node
     * @param low
     * @param upper
     * @return
     */
    private boolean validateBST1(TreeNode node , Integer low, Integer upper) {

        // 验证二叉搜索树树
        if (node == null) {

            return true;
        }

        // 最大的节点
        int value = node.val;

        if (low != null && low >= value) {

            return false;
        }

        if (upper != null && upper <= value) {

            return false;
        }

        if (!validateBST1(node.left, low, value)) {

            return false;
        }

        if (!validateBST1(node.right, value, upper)) {

            return false;
        }

        return true;
    }

    /**
     * 简化写法
     * @param node
     * @param left
     * @param right
     * @return
     */
    private boolean validateBinarySearch(TreeNode node, Integer left, Integer right) {

        if (node == null) {

            return false;
        }

        int value = node.val;

        if (left != null && left >= value) {

            return false;
        }

        if (right != null && right <= value) {

            return false;
        }

        return validateBinarySearch(node.left, left, value) && validateBinarySearch(node.right, value, right);
    }

    /**
     * 维护前驱节点
     */
    private TreeNode pre = null;
    public boolean isValidBST2(TreeNode root) {
        if(root == null) return true;
        boolean left = isValidBST(root.left);
        if(pre != null && pre.val >= root.val) return false;
        pre = root;
        return left && isValidBST(root.right);
    }
}
