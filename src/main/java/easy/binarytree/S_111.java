package easy.binarytree;

import util.TreeNode;

/**
 *
 * Date:2018/5/23
 * 给定一个二叉树，找出其最小深度。
 */
public class S_111 {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        if(root.left==null){
            return 1+minDepth(root.right);
        }

        if(root.right==null){
            return 1+minDepth(root.left);
        }
        return 1+Math.min(minDepth(root.left),minDepth(root.right));
    }
}
