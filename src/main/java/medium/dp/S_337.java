package medium.dp;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hunan
 * @date 2020-01-01
 * @time 20:45
 */
public class S_337 {
    Map<TreeNode, Integer> memo = new HashMap<>();

    /**
     * 记忆化dp
     *
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Integer v = memo.get(root);
        if (v != null) {
            return v;
        } else {
            int v1 = root.val;
            if (root.left != null) {
                v1 += rob(root.left.left);
                v1 += rob(root.left.right);
            }
            if (root.right != null) {
                v1 += rob(root.right.left);
                v1 += rob(root.right.right);
            }
            int v2 = rob(root.left) + rob(root.right);
            int res = Math.max(v1, v2);
            memo.put(root, res);
            return res;
        }
    }

    /**
     * 每个节点可选择偷或者不偷两种状态，根据题目意思，相连节点不能一起偷
     *
     * 当前节点选择偷时，那么两个孩子节点就不能选择偷了
     * 当前节点选择不偷时，两个孩子节点只需要拿最多的钱出来就行(两个孩子节点偷不偷没关系)
     * 我们使用一个大小为2的数组来表示 int[] res = new int[2] 0代表不偷，1代表偷
     * 任何一个节点能偷到的最大钱的状态可以定义为：
     *
     * 当前节点选择不偷: 当前节点能偷到的最大钱数 = 左孩子能偷到的钱 + 右孩子能偷到的钱
     * 当前节点选择偷: 当前节点能偷到的最大钱数 = 左孩子选择自己不偷时能得到的钱 + 右孩子选择不偷时能得到的钱 + 当前节点的钱数
     *
     * 表示为公式如下
     *
     * root[0] = Math.max(rob(root.left)[0], rob(root.left)[1]) + Math.max(rob(root.right)[0], rob(root.right)[1])
     * root[1] = rob(root.left)[0] + rob(root.right)[0] + root.val;
     */
    public int rob2(TreeNode root) {
        int[] result = robInternal(root);
        return Math.max(result[0], result[1]);
    }

    public int[] robInternal(TreeNode root) {
        if (root == null) return new int[2];
        int[] result = new int[2];

        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;

        return result;
    }
}
