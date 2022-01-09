/**
 * 538. 把二叉搜索树转换为累加树
 *
 * @author chen yu
 * @create 2022-01-05 12:19
 */
public class Solution538 {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        int sum = 0;

        if (root == null) {
            return null;
        }
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;


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
