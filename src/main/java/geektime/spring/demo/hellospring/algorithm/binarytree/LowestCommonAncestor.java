package geektime.spring.demo.hellospring.algorithm.binarytree;

import geektime.spring.demo.hellospring.algorithm.definition.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 236 寻找两个节点在二叉树上最近的公共节点
 */
public class LowestCommonAncestor {

    TreeNode findPNodeOrQNode(TreeNode root, TreeNode p, TreeNode q) {

        // 如果节点为空则返回null，如果根节点就是其中一个节点，那么公共节点就是这个节点。
        if (root == null || root == p || root == q) {

            return root;
        }

        // 分别递归查找两个子树
        TreeNode left = findPNodeOrQNode(root.left, p, q);
        TreeNode right = findPNodeOrQNode(root.right, p, q);

        // 如果查询左子树两个节点都不存在，那么就都在另外一个子树中。并且在另外一个子树的查找过程中，最先找到的那个节点就是公共节点。
        if (left == null) {

            return right;
        }

        if (right == null) {

            return left;
        }

        // 如果p和q不在同一个子树下面，那么根节点就是公共节点。
        return root;
    }


}
