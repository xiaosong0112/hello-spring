package geektime.spring.demo.hellospring.algorithm.binarytree;

import geektime.spring.demo.hellospring.algorithm.definition.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricBinaryTree {

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {

            return true;
        } else {

            return check(root.left, root.right);
        }

    }

    public boolean check(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    public boolean isSymmetric2(TreeNode root) {

        if (root == null || root.left == null || root.right == null) {

            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root.left);
        queue.add(root.right);

        while(!queue.isEmpty()) {

            TreeNode node1 = queue.remove();
            TreeNode node2 = queue.remove();

            if (node1 == null && node2 == null) {

                continue;
            }

            if (node1 == null || node2 == null) {

                return false;
            }

            if (node1.val != node2.val) {

                return false;
            }

            queue.add(node1.left);
            queue.add(node2.right);
            queue.add(node2.left);
            queue.add(node1.right);
        }

        return true;
    }

}
