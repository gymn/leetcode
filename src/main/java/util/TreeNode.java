package util;

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
