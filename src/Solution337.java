import java.util.HashMap;

/**
 * 337. 打家劫舍 III
 *
 * @author chen yu
 * @create 2021-11-13 11:17
 *
 *
 *
 */
public class Solution337 {
    HashMap<TreeNode, Integer> select = new HashMap<>();
    HashMap<TreeNode, Integer> noSelect = new HashMap<>();

    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(select.getOrDefault(root, 0), noSelect.getOrDefault(root, 0));
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        select.put(
                node,
                node.val + noSelect.getOrDefault(node.left, 0) + noSelect.getOrDefault(node.right, 0));
        noSelect.put(
                node,
                Math.max(
                        select.getOrDefault(node.left, 0),
                        noSelect.getOrDefault(node.left, 0)) + Math.max(select.getOrDefault(node.right, 0),
                        noSelect.getOrDefault(node.right, 0)));


    }


    class TreeNode {
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
