import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 *
 * @author chen yu
 * @create 2021-11-08 17:08
 */
public class Solution102 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        ArrayDeque<TreeNode> deque = new ArrayDeque<TreeNode>();
        LinkedList<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null) {
            return ans;
        }

        deque.addLast(root);
        while (!deque.isEmpty()) {
            LinkedList<Integer> level_list = new LinkedList<Integer>();

            int levelSize = deque.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = deque.removeFirst();
                level_list.add(node.val);
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
            ans.add(level_list);
        }
        return ans;

    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
