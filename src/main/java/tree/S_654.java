package tree;

import org.junit.Test;
import util.TreeNode;

/**
 * https://leetcode-cn.com/problems/maximum-binary-tree/
 */
public class S_654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return construct(nums, 0, nums.length - 1);
    }

    private TreeNode construct(int[] nums, int start, int end) {
        if (start == end) {
            return new TreeNode(nums[start]);
        }

        int maxIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        TreeNode treeNode = new TreeNode(nums[maxIndex]);
        if (maxIndex > start) {
            treeNode.left = construct(nums, start, maxIndex - 1);
        }
        if (maxIndex < end) {
            treeNode.right = construct(nums, maxIndex + 1, end);
        }
        return treeNode;
    }

    @Test
    public void test() {
        int[] nums = {3, 2, 1, 6, 0, 5};
        constructMaximumBinaryTree(nums);
    }
}
