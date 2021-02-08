package easy;

/**
 *
 * Date:2018/5/7
 */

import util.TreeNode;

/**
 * 相同的树
 */
public class S_100 {
    /**
     * 递归解法
     * 4ms 84.71%
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null)
            return true;
        if(p==null||q==null||(p.val!=q.val))
            return false;
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
}
