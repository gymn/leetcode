package medium.dp;

import util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class S_95 {
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return Collections.emptyList();
        }
        List<TreeNode> dp = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp.add(new TreeNode(1));
            } else {
                List<TreeNode> tmp = new ArrayList<>();
                for (TreeNode tree : dp) {
                    tmp.addAll(addToList(tree, i));
                }
                dp.clear();
                dp.addAll(tmp);
                tmp.clear();
            }

        }
        return dp;
    }

    private List<TreeNode> addToList(TreeNode tree, int n) {
        if (tree == null) {
            return Arrays.asList(new TreeNode(n));
        }
        List<TreeNode> tmp = new ArrayList<>();
        TreeNode node = new TreeNode(n);
        node.left = copyTree(tree);
        tmp.add(node);
        for (TreeNode node1 : addToList(copyTree(tree.right), n)) {
            TreeNode node2 = new TreeNode(tree.val);
            node2.left = copyTree(tree.left);
            node2.right = node1;
            tmp.add(node2);
        }
        return tmp;
    }

    private TreeNode copyTree(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        TreeNode newNode = new TreeNode(treeNode.val);
        newNode.left = copyTree(treeNode.left);
        newNode.right = copyTree(treeNode.right);
        return newNode;
    }

    public static void main(String[] args) {
        List<TreeNode> treeNodes = new S_95().generateTrees(4);
        for (TreeNode node : treeNodes) {
            System.out.println(node);
        }
    }
}
