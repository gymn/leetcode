package easy.binarytree;

/**
 * Author:hunan07(hunan07@meituan.com)
 * Date:2018/5/8
 */

import org.junit.Test;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的最大深度
 */
public class S_104 {
    /**
     * 递归解法
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /**
     * 非递归解法
     *
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        List<TreeNode> list1 = new ArrayList<>();
        list1.add(root);
        List<TreeNode> list2 = new ArrayList<>();
        while (!list1.isEmpty()) {
            depth++;
            for (TreeNode treeNode : list1) {
                if (treeNode.left != null) {
                    list2.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    list2.add(treeNode.right);
                }
            }
            list1 = list2;
            list2 = new ArrayList<>();
        }
        return depth;
    }

    @Test
    public void test() {

    }
}
