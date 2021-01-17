package jzoffer;

import util.TreeNode;

/**
 * 二叉树的最近公共祖先
 */
public class JZ_068_2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return preOrder(root, p, q);
    }

    private TreeNode preOrder(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) {
            return root;
        }

        int countLeft = count(root, q, q);
        if (countLeft == 1) {
            return root;
        }

        if (countLeft == 0) {
            return preOrder(root.right, p, q);
        } else {
            return preOrder(root.left, p, q);
        }
    }

    private int count(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return 0;
        }
        if (p == root || q == root) {
            return 1 + count(root.left, p, q) + count(root.right, p, q);
        } else {
            return count(root.left, p, q) + count(root.right, p, q);
        }
    }
}