/**
 * 129. 求根节点到叶节点数字之和
 *
 * @author chen yu
 * @create 2021-12-24 13:13
 */
public class Solution129 {

    StringBuilder sb = new StringBuilder();
    int sum = 0;

    public int sumNumbers(TreeNode root) {

        dfs(root);
        return sum;
    }

    private void dfs(TreeNode root ) {
        if(root==null){
            return;
        }
        sb.append(root.val);
        if (root.left==null&&root.right == null) {
            sum += Integer.parseInt(sb.toString()) ;
        }

        dfs(root.left);
        dfs(root.right);
        sb.deleteCharAt(sb.length() - 1);
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
