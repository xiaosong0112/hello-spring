package geektime.spring.demo.hellospring.algorithm.binarytree;

import geektime.spring.demo.hellospring.algorithm.definition.TreeNode;

import java.util.Stack;

/**
 * 二叉树的镜像
 */
public class MirrorTree {

    /**
     * 对树进行广度遍历，然后交换两个节点的位置。
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {

        if (root == null) {

            return root;
        }

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();

            if (node != null && node.left != null) {

                stack.push(node.left);
            }

            if (node != null && node.right != null) {

                stack.push(node.right);
            }

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

        }

        return root;
    }


}
