package geektime.spring.demo.hellospring.practise;

import geektime.spring.demo.hellospring.algorithm.definition.NChildrenNode;
import geektime.spring.demo.hellospring.algorithm.definition.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MaxDepth {

    /**
     * 求树的最大深度
     * @param root
     * @return
     */
    public int maxDepth(NChildrenNode root) {

        if (root == null) {

            return 0;
        }

        // 定义最大深度
        int maxDepth = 0;

        // 定义保存所有路径的结果集合
        List<List<Integer>> pathList = new ArrayList<>();

        depLoop(pathList, root, 1);

        for (List<Integer> path : pathList) {

            if (path.size() > maxDepth) {

                maxDepth = path.size();
            }
        }

        return maxDepth;
    }

    public void depLoop(List<List<Integer>> pathList, NChildrenNode node, Integer depth) {

        if (node == null) {

            return;
        }

        if (pathList.size() < depth) {

            pathList.add(new ArrayList<>());
        }

        List<NChildrenNode> childrenNodes = node.children;

        pathList.get(depth - 1).add(node.val);

        for (NChildrenNode childrenNode : childrenNodes) {

            depLoop(pathList, childrenNode, depth + 1);
        }
    }
}
