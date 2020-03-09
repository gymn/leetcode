package medium.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hunan
 * @date 2020-03-09
 * @time 19:41
 */
public class S_3 {
    int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLen = 1;
        int start = 0, end = 0;
        Set<Character> set = new HashSet<>();

        for (; end < s.length(); end++) {
            char curChar = s.charAt(end);
            if (set.contains(curChar)) {
                maxLen = Math.max(maxLen, end - start);
                while (s.charAt(start) != curChar) {
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
            } else {
                set.add(s.charAt(end));
            }
        }
        return Math.max(maxLen, end - start);
    }

    int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLen = 1;
        Map<Character, Integer> map = new HashMap<>();

        for (int start = 0, end = 0; end < s.length(); end++) {
            char curChar = s.charAt(end);
            if (map.containsKey(curChar)) {
                start = Math.max(start, map.get(curChar));
            }

            maxLen = Math.max(maxLen, end - start + 1);
            map.put(curChar, end + 1);
        }
        return maxLen;
    }

    int lengthOfLongestSubstring3(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLen = 1;
        int[] index = new int[128];

        for (int start = 0, end = 0; end < s.length(); end++) {
            char curChar = s.charAt(end);
            if (index[curChar] > 0) {
                start = Math.max(start, index[curChar]);
            }

            maxLen = Math.max(maxLen, end - start + 1);
            index[curChar] = end + 1;
        }
        return maxLen;
    }

    @Test
    public void test() {
        Assert.assertEquals(3, lengthOfLongestSubstring3("abcabcbb"));
        Assert.assertEquals(1, lengthOfLongestSubstring3("a"));
        Assert.assertEquals(2, lengthOfLongestSubstring3("ua"));
        Assert.assertEquals(3, lengthOfLongestSubstring3("abc"));
        Assert.assertEquals(lengthOfLongestSubstring3("pwwkew"), 3);
        Assert.assertEquals(lengthOfLongestSubstring3("bbbbb"), 1);
        Assert.assertEquals(2, lengthOfLongestSubstring3("abbba"));
    }
}
