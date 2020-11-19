package tree;

import util.TreeNode;

/**
 * https://leetcode-cn.com/problems/maximum-binary-tree-ii/
 */
public class S_998 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val > root.val) {
            TreeNode treeNode = new TreeNode(val);
            treeNode.left = root;
            return treeNode;
        }

        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }
}
