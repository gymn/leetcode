package easy;

import java.util.Stack;

/**
 * Created by ad on 2017/8/8.
 */
public class S_020 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] ca = s.toCharArray();
        for(char c: ca) {
            if (!stack.isEmpty() &&
                    (stack.peek() == '('&&c==')'||stack.peek()=='{'&&c=='}'||stack.peek()=='['&&c==']'))
                stack.pop();
            else
                stack.push(c);
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("{}"));
    }
}
