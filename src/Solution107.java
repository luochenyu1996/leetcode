import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

/**
 * 107. 二叉树的层序遍历 II
 *
 * @author chen yu
 * @create 2021-11-08 17:55
 */
public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> ans =  new LinkedList<List<Integer>>();
        ArrayDeque<TreeNode> deque = new ArrayDeque<TreeNode>();
        if(root==null){
            return ans;
        }
        deque.add(root);
        while(!deque.isEmpty()){
            LinkedList<Integer> level_nums= new LinkedList<Integer>();
            int size = deque.size();
            for(int i=0;i<size;i++){

                TreeNode node= deque.removeFirst();
                level_nums.addLast(node.val);
                if(node.left!=null){
                    deque.addLast(node.left);
                }
                if(node.right!=null){
                    deque.addLast(node.right);
                }
            }
            ans.addFirst(level_nums);
        }
        return ans;

    }



       class TreeNode {
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
