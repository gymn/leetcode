package medium.string;

import org.junit.Test;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/reorganize-string/
 */
public class S_767 {
    int[] bt = new int[26];
    List<String> list = new ArrayList<>();

    public String reorganizeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        Arrays.fill(bt, 0);

        for (char c : s.toCharArray()) {
            bt[c - 'a']++;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < bt.length; i++) {
            if (bt[i] > 0 && list.isEmpty() && !set.contains(bt[i])) {
                set.add(bt[i]);
                doReorganize(i, s.length(), "");
            }
        }
        if (list.isEmpty()) {
            return "";
        }
        return list.get(0);
    }

    private void doReorganize(int i, int len, String s) {
        if (!list.isEmpty()) {
            return;
        }
        if (len == 1) {
            list.add(s + ((char) (i + 'a')));
        } else {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < bt.length; j++) {
                if (j != 0 && bt[j] > 0 && !set.contains(bt[j])) {
                    set.add(bt[j]);
                    bt[i]--;
                    doReorganize(j, len - 1, s + ((char) (i + 'a')));
                    bt[i]++;
                }
            }
        }
    }

    public String reorganizeString2(String s) {
        if (s.length() < 2) {
            return s;
        }
        TreeSet<CharCount> ts = new TreeSet<>();
        int[] count = new int[26];
        Arrays.fill(count, 0);
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                ts.add(new CharCount((char) (i + 'a'), count[i]));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!ts.isEmpty()) {
            CharCount c1 = ts.first();
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != c1.c) {
                sb.append(c1.c);
                ts.remove(c1);
                c1.count -= 1;
                if (c1.count > 0) {
                    ts.add(c1);
                }
            } else {
                CharCount c2 = ts.higher(c1);
                if (c2 == null) {
                    return "";
                }
                sb.append(c2.c);
                ts.remove(c2);
                if (--c2.count > 0) {
                    ts.add(c2);
                }
            }
        }
        return sb.toString();
    }



    public static class CharCount implements Comparable {
        public CharCount(char c, int count) {
            this.c = c;
            this.count = count;
        }

        char c;
        int count;

        @Override
        public int compareTo(Object o) {
            CharCount other = (CharCount) o;
            if (this.count != other.count) {
                return other.count - this.count;
            } else {
                return this.c - other.c;
            }
        }
    }

    @Test
    public void test() {
        System.out.println(reorganizeString2("rvhrlpiesrrryrbrrrrrxrkirranrrrrbdrrzgasoxrrr"));
    }
}
