import java.util.ArrayList;
import java.util.List;

/**
 * 653. 两数之和 IV - 输入 BST
 *
 * @author chen yu
 * @create 2022-01-07 15:59
 */
public class Solution653 {

    public static void main(String[] args) {
        Solution653 solution653 = new Solution653();
        TreeNode root = new TreeNode(2);
        root.left=new TreeNode(1);
        root.right=new TreeNode(3);
        boolean target = solution653.findTarget(root, 3);

    }
    public boolean findTarget(TreeNode root, int k) {
        //中序遍历
        ArrayList<Integer> list = new ArrayList<>();
        midView(root,list);
        int left=0;
        int right=list.size()-1;

        while (left<right){
            if(list.get(left)+list.get(right)>k){
                right--;
            }else if(list.get(left)+list.get(right)<k){
                left++;
            }else {
                return true;
            }
        }
        return false;
    }

    private void midView(TreeNode root,List<Integer> list){
        if(root==null){
            return ;
        }
        midView(root.left,list);
        list.add(root.val);
        midView(root.right,list);
    }





    public static class TreeNode {
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
