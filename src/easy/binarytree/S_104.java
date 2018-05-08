package easy.binarytree;

/**
 * Author:hunan07(hunan07@meituan.com)
 * Date:2018/5/8
 */

import util.TreeNode;

/**
 * 二叉树的最大深度
 */
public class S_104 {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
