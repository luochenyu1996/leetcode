import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 *
 * @author chen yu
 * @create 2021-11-24 21:52
 */
public class Solution113 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        ArrayList<Integer> path = new ArrayList<>();
        ArrayList<List<Integer>> ans = new ArrayList<>();
        dfs(root, targetSum, path, ans);
        return ans;
    }

    private void dfs(TreeNode root, Integer targetSum, List<Integer> path, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                path.add(root.val);
                ans.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }

        path.add(root.val);
        if (root.left != null) {
            dfs(root.left, targetSum - root.val, path, ans);
        }

        //这两行留和不留都一行
        path.remove(path.size() - 1);
        path.add(root.val);
        //这两行留和不留都一行

        if (root.right != null) {
            dfs(root.right, targetSum - root.val, path, ans);
        }
        path.remove(path.size() - 1);

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
