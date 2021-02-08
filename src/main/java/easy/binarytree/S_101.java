package easy.binarytree;

/**
 *
 * Date:2018/5/8
 */

import util.TreeNode;

/**
 * 对称二叉树
 */
public class S_101 {
    public boolean sysmmetric(TreeNode t1, TreeNode t2){
        if(t1==null&&t2==null){
            return true;
        }
        if(t1==null||t2==null||t1.val != t2.val){
            return false;
        }

        return sysmmetric(t1.left, t2.right)&&sysmmetric(t1.right, t2.left);
    }

    /**
     * 递归解法
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }

        return sysmmetric(root.left,root.right);
    }


}
