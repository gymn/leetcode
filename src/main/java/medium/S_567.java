package medium;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author hunan
 * @date 2019-09-16
 * @time 23:37
 */
public class S_567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        int[] source = new int[26];
        int[] window = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            source[s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(source, window)) {
            return true;
        }

        for (int i = 1; i <= s2.length() - s1.length(); i++) {
            window[s2.charAt(i - 1) - 'a']--;
            window[s2.charAt(i + s1.length()-1) - 'a']++;

            if (Arrays.equals(source, window)) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void testCheckInclusion() {
        System.out.println(checkInclusion("ab", "eidboaooo"));
    }
}
