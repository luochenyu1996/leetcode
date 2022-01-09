/**
 * 100. 相同的树
 *
 * @author chen yu
 * @create 2021-12-24 14:34
 */
public class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null&&q==null){
            return true;
        }
        if (p==null||q==null){
            return false;
        }

        if(p.left==null &&p.right==null&&q.left==null &&q.right==null&& p.val== q.val){
            return true;
        }else if(p.val!= q.val){
            return false;
        }

        boolean leftAns = isSameTree(p.left, q.left);
        boolean rightAns = isSameTree(p.right, q.right);
        return  leftAns&&rightAns;

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
