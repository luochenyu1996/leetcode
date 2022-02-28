import java.util.HashMap;

/**
 * 剑指 Offer 07. 重建二叉树
 *
 * @author chen yu
 * @create 2022-02-28 19:24
 */
public class SolutionJZ07 {


    int[] preorder;
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        //对中序遍历进行记录
        for(int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return recur(0, 0, inorder.length - 1);
    }
    TreeNode recur(int root, int left, int right) {
        if(left > right) {
            return null;
        }                          // 递归终止
        TreeNode node = new TreeNode(preorder[root]);
        //获取的是中序遍历的index
        int i = map.get(preorder[root]);
        // 构建左子树   注意点：中序遍用的left right，而 root 是前序遍历用的
        node.left = recur(root + 1, left, i - 1);              // 开启左子树递归
        //构建右子树 ，i-left +1 == 左子数的长度
        node.right = recur(root + i - left + 1, i + 1, right); // 开启右子树递归
        return node;
    }



    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}

