package hard;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by ad on 2017/6/21.
 */
public class S_032 {
    public static int longestValidParentheses(String s) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!stack1.isEmpty() && stack1.peek() == '(' && s.charAt(i) == ')') {
                stack1.pop();
                stack2.pop();
            } else {
                stack1.push(s.charAt(i));
                stack2.push(i);
            }
        }

        if (stack2.isEmpty()) {
            return s.length();
        }
        int size = stack2.size();
        int max = Math.max(stack2.get(0), s.length() - stack2.get(size - 1) - 1);
        for (int i = 1; i < stack2.size(); i++) {
            max = Math.max(max, stack2.get(i) - stack2.get(i - 1) - 1);
        }
        return max;
    }

    @Test
    public void test() {
        System.out.println(longestValidParentheses(""));
    }
}
