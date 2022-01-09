/**
 * 112. 路径总和
 *
 * @author chen yu
 * @create 2021-12-24 12:59
 */
public class Solution112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root==null){
            return false;
        }

       return dfs(root.left,root.right,targetSum-root.val);
    }

    private boolean dfs(TreeNode left, TreeNode right , int targetSum){

        if(right==null&&left==null&& targetSum==0){
            return true;
        }else if(right == null && left == null){
            return false;
        }
        boolean leftAns=false;
        boolean rightAns=false;
        if(left!=null){
             leftAns=dfs(left.left, left.right, targetSum - left.val);
        }
        if(right!=null){
          rightAns = dfs(right.left, right.right, targetSum - right.val);
        }
        return  leftAns||rightAns;
    }


      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

}
