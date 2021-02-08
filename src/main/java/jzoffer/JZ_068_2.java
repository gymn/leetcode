package jzoffer;

import org.junit.Test;
import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 二叉树的最近公共祖先
 */
public class JZ_068_2 {
    /**
     * 解法一：
     * 类似于68-1的解法，只不过因为节点值是无序的，所以在遍历数节点的时候需要递归的计算其左子树和右子树是否分别包含p和q
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return preOrder(root, p, q);
    }

    private TreeNode preOrder(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        int countLeft = count(root.left, p, q);
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
        if (p.val == root.val || q.val == root.val) {
            return 1 + count(root.left, p, q) + count(root.right, p, q);
        } else {
            return count(root.left, p, q) + count(root.right, p, q);
        }
    }

    /**
     * 作为解法一的改进版本，我们可以先计算出每个树节点及其子树中包含p或q值得数量，避免重复计算
     */
    Map<Integer, Integer> record = new HashMap<>();

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        count2(root, p, q);
        return preOrder2(root, p, q);
    }

    private TreeNode preOrder2(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        if (root.left == null || record.get(root.left.val) == 0) {
            return preOrder2(root.right, p, q);
        } else if (root.right == null || record.get(root.right.val) == 0) {
            return preOrder2(root.left, p, q);
        } else {
            return root;
        }
    }

    private int count2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return 0;
        }
        if (p.val == root.val || q.val == root.val) {
            int c = 1 + count2(root.left, p, q) + count2(root.right, p, q);
            record.put(root.val, c);
            return c;
        } else {
            int c = count2(root.left, p, q) + count2(root.right, p, q);
            record.put(root.val, c);
            return c;
        }
    }

    @Test
    public void test() {
        TreeNode tree = TreeNode.from(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
        TreeNode ans = lowestCommonAncestor2(tree, new TreeNode(2), new TreeNode(4));
        System.out.println(ans.val);
    }
}