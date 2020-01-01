package Hard.dp;

import org.junit.Test;

import java.util.*;

/**
 * @author hunan
 * @date 2020-01-01
 * @time 14:41
 */
public class S_140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int maxlen = 0;
        int minlen = Integer.MAX_VALUE;
        for (String s1 : wordDict) {
            maxlen = Math.max(maxlen, s1.length());
            minlen = Math.min(minlen, s1.length());
        }

        List<List<String>> dp = new ArrayList<>(s.length());
        List<Integer> startIndices = new ArrayList<>();

        if (wordDict.contains(s.substring(0, 1))) {
            dp.add(Arrays.asList(s.substring(0, 1)));
        } else {
            dp.add(new ArrayList<>());
        }
        startIndices.add(0);
        if (!dp.get(0).isEmpty()) {
            startIndices.add(1);
        }

        for (int i = 1; i < s.toCharArray().length; i++) {
            List<String> tmp = new ArrayList<>();
            for (int j = startIndices.size() - 1; j >= 0; j--) {
                int start = startIndices.get(j);
                int len = i + 1 - start;

                if (len <= maxlen && len >= minlen) {
                    String s1 = s.substring(start, i + 1);
                    if (dict.contains(s1)) {
                        if (start == 0) {
                            tmp.add(s1);
                        } else {
                            for (String s2 : dp.get(start - 1)) {
                                tmp.add(s2 + " " + s1);
                            }
                        }
                    }
                }
            }
            dp.add(tmp);
            if (!tmp.isEmpty()) {
                startIndices.add(i + 1);
            }
        }
        return dp.get(dp.size() - 1);
    }


    public List<String> wordBreak2(String s, Set<String> wordDict) {
        return word_Break(s, wordDict, 0);
    }

    HashMap<Integer, List<String>> map = new HashMap<>();

    public List<String> word_Break(String s, Set<String> wordDict, int start) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        LinkedList<String> res = new LinkedList<>();
        if (start == s.length()) {
            res.add("");
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                List<String> list = word_Break(s, wordDict, end);
                for (String l : list) {
                    res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
                }
            }
        }
        map.put(start, res);
        return res;
    }

    public List<String> wordBreak3(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Set<Integer> wordLen = new HashSet<>();
        for (String s1 : wordDict) {
            wordLen.add(s1.length());
        }
        return doBreak(s, 0, dict, wordLen);
    }

    Map<Integer, List<String>> memo = new HashMap<>();

    private List<String> doBreak(String s, int start, Set<String> wordDict, Set<Integer> wordLen) {
        List<String> arr = new ArrayList<>();
        for (Integer len : wordLen) {
            if (start + len <= s.length()) {
                String s1 = s.substring(start, start + len);
                if (wordDict.contains(s1)) {
                    if (start + len == s.length()) {
                        arr.add(s1);
                    } else {
                        List<String> list1 = memo.get(start + len);
                        if (list1 == null) {
                            list1 = doBreak(s, start + len, wordDict, wordLen);
                            memo.put(start + len, list1);
                        }
                        for (String s2 : list1) {
                            arr.add(s1 + " " + s2);
                        }
                    }
                }
            }
        }
        return arr;
    }

    @Test
    public void test() {
        String s = "aaaaaaaaa";
        List<String> wordDict = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
        System.out.println(wordBreak3(s, wordDict));
    }
}
