/**
 * 450. 删除二叉搜索树中的节点
 *
 * @author chen yu
 * @create 2021-12-31 11:38
 */
public class Solution450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return  root;

        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            if (root.left == null) {
                TreeNode rightNode = root.right;
                //原先的删除了就要进行断开
                root.right = null;
                return rightNode;
            }

            if (root.right == null) {
                TreeNode leftNode = root.left;
                root.left = null;
                return leftNode;

            }
            // 使用当前 node 的后继代替（也可以使用 node 的前驱代替）   中序遍历的前驱和后继
            //找到后继节点
            TreeNode successor = minimum(root.right);

            //移除后继节点的关系再进行替换
            successor.right = removeMin(root.right);
            successor.left = root.left;

            root.left = null;
            root.right = null;
            return successor;
        }


    }

    private TreeNode minimum(TreeNode node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    private TreeNode removeMin(TreeNode root) {
        // 从根结点一直向左子树方向走，直到当前结点不存在左子树的时候，当前结点就是整棵树中 key 最小的结点
        if (root.left == null) {
            // 仔细体会这个逻辑，用当前结点的右子树替换当前结点，因此，需要先保存当前结点的右子树
            TreeNode rightNode = root.right;
            // 切断引用，让当前结点成为游离结点，
            root.right = null;
            return rightNode;
        }
        root.left = removeMin(root.left);
        return root;
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
