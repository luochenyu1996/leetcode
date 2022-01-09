/**
 * 1038. 把二叉搜索树转换为累加树
 * 树的后顺遍历变形
 * @author chen yu
 * @create 2022-01-07 16:23
 */
public class Solution1038 {
    int sum=0;
    public TreeNode bstToGst(TreeNode root) {

        if(root==null){
            return  null;
        }
        bstToGst(root.right);
        sum += root.val;
        root.val = sum;
        bstToGst(root.left);


       return root;
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
