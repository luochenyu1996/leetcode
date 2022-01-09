/**
 * 108. 将有序数组转换为二叉搜索树
 *
 * @author chen yu
 * @create 2022-01-05 13:20
 */
public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        return sortedArrayToBST(0, len, nums);


    }

    TreeNode sortedArrayToBST(int left, int right, int[] nums) {
        if (left >= right) {
            return null;
        }

        int mid = (right + left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(left, mid, nums);
        root.right = sortedArrayToBST(mid + 1, right, nums);
        return root;
    }


    private class TreeNode {
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




