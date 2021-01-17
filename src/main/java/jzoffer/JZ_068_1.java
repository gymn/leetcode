package jzoffer;

import util.TreeNode;

/**
 * 二叉搜索树的最近公共祖先
 */
public class JZ_068_1 {
    /**
     * 对于最近公共祖先问题可以理解为找到一个节点，使得p和q分列其两侧子树中
     * 因为搜索二叉树的性质，只需要找到一个节点使得节点值处于p和q之间即可
     * 可以使用
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < q.val) {
            return preOrder(root, p.val, q.val);
        } else {
            return preOrder(root, q.val, p.val);
        }
    }

    private TreeNode preOrder(TreeNode root, int left, int right) {
        if (root.val >= left && root.val <= right) {
            return root;
        }
        if (root.val < left) {
            return preOrder(root.right, left, right);
        } else {
            return preOrder(root.left, left, right);
        }
    }
}
