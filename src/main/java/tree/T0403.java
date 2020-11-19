package tree;

import org.junit.Test;
import util.ListNode;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/list-of-depth-lcci/
 */
public class T0403 {
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return new ListNode[0];
        }
        List<ListNode> res = new ArrayList<>();

        List<TreeNode> p1 = new ArrayList<>();
        List<TreeNode> p2 = new ArrayList<>();
        p1.add(tree);
        while (!p1.isEmpty()) {
            p2.clear();
            ListNode node = null;
            for (TreeNode tn : p1) {
                if (node == null) {
                    node = new ListNode(tn.val);
                    res.add(node);
                } else {
                    node.next = new ListNode(tn.val);
                    node = node.next;
                }

                if (tn.left != null) {
                    p2.add(tn.left);
                }

                if (tn.right != null) {
                    p2.add(tn.right);
                }
            }
            p1.clear();
            p1.addAll(p2);
        }

        return res.toArray(new ListNode[0]);
    }

    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.right = new TreeNode(7);
        treeNode.left.left.left = new TreeNode(8);
        listOfDepth(treeNode);
    }
}
