package sort;

/**
 * 222. 完全二叉树的节点个数
 *
 * @author chen yu
 * @create 2021-12-24 14:49
 */
public class Solution222 {
    int  count=0;
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        count++;
        countNodes(root.left);
        countNodes(root.right);
        return count;
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
