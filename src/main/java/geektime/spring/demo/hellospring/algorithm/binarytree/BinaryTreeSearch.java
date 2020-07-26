package geektime.spring.demo.hellospring.algorithm.binarytree;

import geektime.spring.demo.hellospring.algorithm.definition.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 普通二叉树遍历（不是搜索二叉树）
 */
public class BinaryTreeSearch {

    /**
     * 广度遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        // 创建二维数组接收每层的结点
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        // 创建队列依次存放每层的结点（后面用于判断当前节点是否还有子节点，如果没有了，后面的while循环就终止了）
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            // 创建数组来接收出队的结点，存放的是每层的结点
            List<Integer> tmp = new ArrayList<>();

            int len = q.size();
            for (int i = 0; i < len; i++) {

                // 定义 node 接收出队结点，然后加入数组 tmp 中
                TreeNode node = q.poll();
                tmp.add(node.val);

                // 如果有左右孩子，就依次入队、出队、进数组
                if (node.left != null) {

                    q.add(node.left);
                }
                if (node.right != null) {

                    q.add(node.right);
                }
            }

            // 数组每次都是放的一层的结点，然后一层一层的放入二维数组中
            ans.add(tmp);
        }

        return ans;
    }

    /**
     * 深度优先
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {

        if(root == null) return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        dfs(root, list, 1);
        return list;
    }

    public void dfs(TreeNode root, List<List<Integer>> list, int level){

        if(root == null) return;

        // 因为是深度遍历，但是又要按照没个层的结构去返回，所以只在第一次遍历的时候
        // 创建每一层的数据结构，其他的时候直接按照层数的key去获取结构就可以了。
        if(list.size() < level) {

            list.add(new ArrayList<Integer>());
        }
        list.get(level - 1).add(root.val);
        dfs(root.left, list, level + 1);
        dfs(root.right, list, level + 1);
    }

    public static void main(String[] args) {

        BinaryTreeSearch binaryTreeSearch = new BinaryTreeSearch();
        TreeNode treeNode = new TreeNode(0);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        TreeNode left = treeNode.left;
        TreeNode right = treeNode.right;

        binaryTreeSearch.levelOrder(treeNode);
    }
}
