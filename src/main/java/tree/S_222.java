package tree;

import util.TreeNode;

/**
 * https://leetcode-cn.com/problems/count-complete-tree-nodes/
 */
public class S_222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
