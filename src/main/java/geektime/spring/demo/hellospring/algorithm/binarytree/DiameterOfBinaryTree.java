package geektime.spring.demo.hellospring.algorithm.binarytree;

import geektime.spring.demo.hellospring.algorithm.definition.TreeNode;

/**
 * 二叉树最大直径
 */
public class DiameterOfBinaryTree {

    int max=0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }
    public int depth(TreeNode node){

        if(node==null){
            return 0;
        }
        int Left = depth(node.left);
        int Right = depth(node.right);
        max=Math.max(Left+Right,max);//将每个节点最大直径(左子树深度+右子树深度)当前最大值比较并取大者
        return Math.max(Left,Right)+1;//返回节点深度
    }
}
