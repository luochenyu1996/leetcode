/**
 * 236. 二叉树的最近公共祖先
 *
 * @author chen yu
 * @create 2022-01-04 21:52
 */
public class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q){
            return root;
        }

        TreeNode left= lowestCommonAncestor(root.left, p, q);
        TreeNode right= lowestCommonAncestor(root.right, p, q);

        if(left == null && right == null){
            return null;
        }

        if(right==null){
            return left;
        }

        if(left == null){
            return right;
        }

        return root;
    }






    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
