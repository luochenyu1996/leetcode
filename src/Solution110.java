/**
 * 110. 平衡二叉树
 *
 * @author chen yu
 * @create 2021-12-28 12:32
 */
public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        int leftDepth = depthFunc(root.left);
        int rightDepth = depthFunc(root.right);
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(leftDepth - rightDepth) <= 1;
    }

    private int depthFunc(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(depthFunc(node.left), depthFunc(node.right)) + 1;
    }


    public class TreeNode {
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
