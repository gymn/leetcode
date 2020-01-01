package medium.dp;

import java.util.*;

/**
 * @author hunan
 * @date 2020-01-01
 * @time 13:05
 */
public class S_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length()];
        dp[0] = wordDict.contains(s.substring(0, 1));
        for (int i = 1; i < s.toCharArray().length; i++) {
            String tmp = "";
            for (int j = i; ; j--) {
                if (j < 0) {
                    dp[i] = false;
                    break;
                }
                tmp = s.charAt(j) + tmp;
                if (dict.contains(tmp) && (j == 0 || dp[j - 1])) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }

    /**
     * 4ms
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int maxlen = 0;
        int minlen = Integer.MAX_VALUE;
        for (String s1 : wordDict) {
            maxlen = Math.max(maxlen, s1.length());
            minlen = Math.min(minlen, s1.length());
        }

        boolean[] dp = new boolean[s.length()];
        List<Integer> startIndices = new ArrayList<>();

        dp[0] = wordDict.contains(s.substring(0, 1));
        startIndices.add(0);
        if (dp[0]) {
            startIndices.add(1);
        }

        for (int i = 1; i < s.toCharArray().length; i++) {
            for (int j = startIndices.size() - 1; j >= 0; j--) {
                int len = i + 1 - startIndices.get(j);
                if (len <= maxlen && len >= minlen && dict.contains(s.substring(startIndices.get(j), i + 1))) {
                    dp[i] = true;
                    break;
                }
            }

            if (dp[i]) {
                startIndices.add(i + 1);
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        String s = "abcd";
        List<String> wordDict = Arrays.asList("a", "abc", "b", "cd");
        System.out.println(new S_139().wordBreak2(s, wordDict));
    }
}
