package jzoffer;

import org.junit.Test;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树的第k大节点
 */
public class JZ_054 {
    /**
     * 思路：中序遍历
     */
    List<Integer> ans = new ArrayList<>();

    public int kthLargest(TreeNode root, int k) {
        midOrder(root, k);
        return ans.get(ans.size() - k);
    }

    private void midOrder(TreeNode root, int k) {
        if (root.left != null) {
            midOrder(root.left, k);
        }
        ans.add(root.val);
        if (root.right != null) {
            midOrder(root.right, k);
        }
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.from(new Integer[]{5, 3, 6, 2, 4, null, null, 1});
        System.out.println(kthLargest(root, 3));
    }
}
