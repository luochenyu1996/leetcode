import java.util.ArrayList;
import java.util.List;

/**
 * 230. 二叉搜索树中第K小的元素
 *
 * @author chen yu
 * @create 2022-01-07 16:41
 */
public class Solution230 {
    int myK = 0;
    int ans=-1;


    public static void main(String[] args) {
        Solution230 solution230 = new Solution230();
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(3);


        int i = solution230.kthSmallest(treeNode, 2);
        System.out.println(i);
    }

    public int kthSmallest(TreeNode root, int k) {
        myK = k;
        ArrayList<Integer> list = new ArrayList<>();
        kthSmallest_helper(root, list);
        return list.get(myK-1);
    }

    private void kthSmallest_helper(TreeNode root, List<Integer> list) {
        if(root==null){
            return;
        }
        if(list.size()==myK){
           return;
        }

        kthSmallest_helper(root.left, list);
        list.add(root.val);
        kthSmallest_helper(root.right, list);
    }


    public static   class TreeNode {
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
