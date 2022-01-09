/**
 * 449. 序列化和反序列化二叉搜索树
 *
 * @author chen yu
 * @create 2022-01-07 14:49
 */
public class Solution449 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(3);


        Solution449 solution449 = new Solution449();
        String serialize = solution449.serialize(treeNode);
        System.out.println(serialize);


    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        serialize_helper(root,sb);
        return sb.toString();
    }

    private void serialize_helper(TreeNode root,StringBuilder sb){
        if(root==null){
            return;
        }
        sb.append(root.val);
        serialize_helper(root.left,sb);
        serialize_helper(root.right,sb);
    }


    public TreeNode deserialize(String data) {
        int len = data.length();
        return  deserialize_helper(data, 0, len);
    }

    private TreeNode  deserialize_helper(String data ,int left ,int right){
        if(right<=left){
            return  null;
        }
        int mid=(right+left)/2;
        TreeNode root = new TreeNode(data.charAt(mid));
        //左子树
        root.left=deserialize_helper(data,left,mid);
        root.right=deserialize_helper(data,mid+1,right);
        return  root;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
