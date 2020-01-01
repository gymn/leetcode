package Hard;

import org.junit.Test;

import java.util.Stack;

/**
 * @author hunan
 * @date 2019-09-10
 * @time 23:30
 */
public class S_316 {

    public String removeDuplicateLetters(String s) {
        if (s.length() == 0) {
            return s;
        }
        int[] charCount = new int[26];
        boolean[] isInStack = new boolean[26];

        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            charCount[c - 'a']--;
            if (!isInStack[c - 'a']) {
                while (!stack.isEmpty() && stack.peek() >= c && charCount[stack.peek() - 'a'] > 0) {
                    isInStack[stack.pop() - 'a'] = false;
                }
                stack.push(c);
                isInStack[c - 'a'] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    @Test
    public void test() {
        System.out.println(removeDuplicateLetters("bbcaac"));
    }
}
