/**
 * 235. 二叉搜索树的最近公共祖先
 *
 * @author chen yu
 * @create 2022-01-07 12:29
 */
public class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null){
            return null;
        }

        if(root.val==q.val||root.val==p.val){
            return root;
        }
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

        if(leftNode==null&&rightNode==null){
            return null;
        }




        if(leftNode==null){
            return rightNode;
        }
        if(rightNode==null){
            return leftNode;
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
