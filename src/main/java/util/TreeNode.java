package util;

import sun.reflect.generics.tree.Tree;

/**
 * Author:hunan07(hunan07@meituan.com)
 * Date:2018/5/7
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode from(Integer[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(nums[0]);
        for (int i = 0; i < nums.length; i++) {
            int leftIdx = 2 * i + 1;
            int rightIdx = 2 * i + 2;
            if (leftIdx < nums.length && nums[leftIdx] != null) {

            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        sb.append(", ");
        sb.append(left == null ? "null" : left.toString());
        sb.append(", ");
        sb.append(right == null ? "null" : right.toString());
        return sb.toString();
    }
}
