package tree;

import org.junit.Test;
import util.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 */
public class S_589 {
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        doPreorder(root, result);
        return result;
    }

    private void doPreorder(Node root, List<Integer> result) {
        result.add(root.val);
        if (root.children != null) {
            for (Node child : root.children) {
                doPreorder(child, result);
            }
        }
    }

    public List<Integer> preorder2(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            result.add(pop.val);

            for (int i = pop.children.size() - 1; i >= 0; i--) {
                stack.push(pop.children.get(i));
            }
        }
        return result;
    }
}
