package geektime.spring.demo.hellospring.algorithm.binarytree;

import geektime.spring.demo.hellospring.algorithm.definition.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 合并二叉树
 */
public class MergeBinaryTree {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 == null) {

            return t2;
        }

        if (t2 == null) {

            return t1;
        }

        int sum = t1.val + t2.val;

        TreeNode result = new TreeNode(sum);
        result.left = mergeTrees(t1.left, t2.left);
        result.right = mergeTrees(t1.right, t2.right);

        return result;
    }
}
