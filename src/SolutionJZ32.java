
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 *
 * @author chen yu
 * @create 2021-11-09 11:41
 */
public class SolutionJZ32 {

    public static void main(String[] args) {
        System.out.println(1%2);
        System.out.println(1/2);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        int depth=0;
        ArrayDeque<TreeNode> deque =new ArrayDeque<TreeNode>();
        ArrayList<List<Integer>> ans =new ArrayList<List<Integer>>();

        deque.addLast(root);

        while(!deque.isEmpty()){
            int size = deque.size();
            ArrayList<Integer> level_nums=new ArrayList<Integer>();
            depth++;
            for(int i=0;i< size;i++){
                TreeNode node= deque.removeFirst();
                level_nums.add(node.val);
                if(depth%2==0){
                    //先进right
                    if(node.right!=null){
                        deque.add(node.right);
                    }
                    if(node.left!=null){
                        deque.add(node.left);
                    }
                }else{
                    if(node.left!=null){
                        deque.add(node.left);
                    }

                    if(node.right!=null){
                        deque.add(node.right);
                    }


                }
            }
            ans.add(level_nums);

        }
        return ans;

    }



      public class TreeNode {
         int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

}
