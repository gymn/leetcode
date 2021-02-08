package util;

/**
 *
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

        TreeNode[] nodes = new TreeNode[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=null) {
                nodes[i] = new TreeNode(nums[i]);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int leftIdx = 2 * i + 1;
            int rightIdx = 2 * i + 2;
            if (leftIdx < nums.length && nodes[leftIdx] != null) {
                nodes[i].left = nodes[leftIdx];
            }

            if(rightIdx<nums.length&&nodes[rightIdx]!=null){
                nodes[i].right = nodes[rightIdx];
            }
        }
        return nodes[0];
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
