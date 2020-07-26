package geektime.spring.demo.hellospring.algorithm.binarytree;

import geektime.spring.demo.hellospring.algorithm.definition.TreeNode;

/**
 * 二叉树的深度
 */
public class MaxDepth {

    private int maxDepth = 0;

    /**
     * 二叉树最大深度的计算逻辑是 找到节点的左孩子的路径 + 右孩子路径的最大值
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {

        // 就是二叉树的深度遍历
        if (root == null) {

            return maxDepth;
        }

        maxDepth(root, 0);

        return maxDepth;
    }

    public void maxDepth(TreeNode root, int depth) {

        if (root == null) {

            return;
        }

        depth++;

        if (depth > maxDepth) {

            maxDepth = depth;
        }

        maxDepth(root.left, depth);
        maxDepth(root.right, depth);
    }
}
