package easy.binarytree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Date:2018/5/23
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 */
public class S_110 {
    public int getDeepth(TreeNode root, List<Boolean> flag){
        if(root == null){
            return 0;
        }
        int ld = getDeepth(root.left,flag);
        int rd = getDeepth(root.right,flag);
        if(Math.abs(ld-rd)>1)
            flag.set(0,false);
        return 1+Math.max(ld,rd);
    }

    public boolean isBalanced(TreeNode root) {
        List<Boolean> flag = new ArrayList<>(1);
        flag.add(true);
        getDeepth(root,flag);
        return flag.get(0);
    }

    public static void main(String[] args) {
        S_110 s_110 = new S_110();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(s_110.isBalanced(root));
    }
}
