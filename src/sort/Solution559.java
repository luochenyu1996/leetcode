package sort;

import java.util.List;

/**
 * 559. N 叉树的最大深度
 *
 * @author chen yu
 * @create 2021-11-21 20:09
 */
public class Solution559 {
    public int maxDepth(Node root) {
        if(root==null){
            return  0;
        }
        int maxCount=0;
        for (Node child : root.children) {
            maxCount=Math.max(maxDepth(child),maxCount);
        }
        maxCount=maxCount+1;
        return maxCount;
    }

}



class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
