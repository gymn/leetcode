package easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S_830 {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            int count = 1;
            while (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
                i++;
                count++;
            }
            if (count >= 3) {
                ans.add(Arrays.asList(i - count, i - 1));
            }
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(largeGroupPositions("aaa"));
    }
}
