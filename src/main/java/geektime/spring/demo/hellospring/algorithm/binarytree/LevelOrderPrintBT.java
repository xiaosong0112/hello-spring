package geektime.spring.demo.hellospring.algorithm.binarytree;

import geektime.spring.demo.hellospring.algorithm.definition.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 广度优先打印二叉树元素
 */
public class LevelOrderPrintBT {

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {

            return new ArrayList<>();
        }

        // 记录打印结果
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            List<Integer> levelList = new ArrayList<>();

            int length = queue.size();

            for (int i = 0; i < length; i++) {

                TreeNode treeNode = queue.poll();

                if (treeNode != null) {

                    levelList.add(treeNode.val);

                    if (treeNode.left != null) {

                        queue.add(treeNode.left);
                    }

                    if (treeNode.right != null) {

                        queue.add(treeNode.right);
                    }
                } else {

                    levelList.add(null);
                }
            }

            result.add(levelList);
        }

        return result;
    }

    /**
     * 深度遍历
     * @param root
     * @return
     */
    public List<List<Integer>> depthOrder(TreeNode root) {

        if (root == null) {

            return new ArrayList<>();
        }

        // 记录打印结果
        List<List<Integer>> result = new ArrayList<>();

        depthOrder(root, result, 1);
        return result;
    }

    private void depthOrder(TreeNode root, List<List<Integer>> result, int level) {

        if (root == null) {

            return;
        }

        if (result.size() < level) {

            result.add(new ArrayList<>());
        }

        result.get(level - 1).add(root.val);
        depthOrder(root.left, result, level + 1);
        depthOrder(root.right, result, level + 1);
    }
}
