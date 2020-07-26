package geektime.spring.demo.hellospring.algorithm.definition;

import java.util.List;

public class NChildrenNode {

    public int val;
    public List<NChildrenNode> children;

    public NChildrenNode() {

    }

    public NChildrenNode(int val, List<NChildrenNode> children) {

        this.val = val;
        this.children = children;
    }
}
