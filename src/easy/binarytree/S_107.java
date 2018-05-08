package easy.binarytree;

/**
 * Author:hunan07(hunan07@meituan.com)
 * Date:2018/5/8
 */

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 *二叉树的层次遍历 II
 */
public class S_107 {
    /**
     * 可以通过但是时间太长
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;

        Stack<List<TreeNode>> stack = new Stack<>();

        List<TreeNode> fontList = new ArrayList<>();
        fontList.add(root);
        stack.push(fontList);

        while(!stack.peek().isEmpty()){
            List<TreeNode> backList = new ArrayList<>();
            for(TreeNode node: stack.peek()){
                if(node.left!=null)
                    backList.add(node.left);
                if(node.right!=null)
                    backList.add(node.right);
            }

            stack.push(backList);
        }

        stack.pop();
        while(!stack.isEmpty()){
            List<Integer> list = stack.pop().stream().map(node->node.val).collect(Collectors.toList());
            res.add(list);
        }
        return res;
    }

    /**
     * 优化解法 3ms
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if(root==null)
            return res;

        List<TreeNode> nodelist = new ArrayList<>();
        nodelist.add(root);

        while(!nodelist.isEmpty()){
            List<Integer> tmpList = new ArrayList<>();
            ArrayList<TreeNode> childList = new ArrayList<>();

            for(TreeNode treeNode: nodelist){
                tmpList.add(treeNode.val);
                if(treeNode.left!=null)
                    childList.add(treeNode.left);
                if(treeNode.right!=null)
                    childList.add(treeNode.right);
            }

            res.addFirst(tmpList);
            nodelist = childList;
        }
        return res;
    }
}
