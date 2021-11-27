import java.util.ArrayDeque;
import java.util.LinkedList;

/**
 * 101. 对称二叉树
 * ArrayDeque 中的元素不允许为非空 因此这里不能用
 *
 * @author chen yu
 * @create 2021-11-27 11:41
 */
public class Solution101 {
    public boolean isSymmetric(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root.left);
        queue.add(root.right);
        while (queue.size() > 0) {
            TreeNode left = queue.removeFirst();
            TreeNode right = queue.removeFirst();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            queue.addLast(left.left);
            queue.addLast(right.right);
            queue.addLast(left.right);
            queue.addLast(right.left);
        }
        return true;
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






