/**
 * 701. 二叉搜索树中的插入操作
 *
 * @author chen yu
 * @create 2022-01-05 11:27
 */
public class Solution701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }

        if (root.val<val){
           root.left = insertIntoBST(root.left, val);
        }else {
             root.right = insertIntoBST(root.right, val);
        }
        return  root;
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
