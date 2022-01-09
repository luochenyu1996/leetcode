
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 199. 二叉树的右视图
 *
 * @author chen yu
 * @create 2021-12-28 11:54
 */
public class Solution199 {

    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return null;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            ArrayList<Integer> levelResult = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode outNode = queue.poll();
                levelResult.add(outNode.val);
                if(outNode.left!=null){
                    queue.add(outNode.left);
                }
                if(outNode.right!=null){
                    queue.add(outNode.right);
                }

            }
            result.add(levelResult);
        }

        for (List<Integer>  levelResult : result) {
            ans.add(levelResult.get(levelResult.size()-1));
        }
        return ans;
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
