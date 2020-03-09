package hard;

/**
 * Created by ad on 2017/6/21.
 */
public class S_44 {
    /**
     * '?' Matches any single character.
     * '*' Matches any sequence of characters (including the empty sequence).
     * <p>
     * The matching should cover the entire input string (not partial).
     */
    public static boolean isMatch(String s, String p) {
        boolean[][] a = new boolean[s.length() + 1][p.length() + 1];
        a[0][0] = true;
        for (int j = 1; j < p.length() + 1; j++) {
            if (p.charAt(j - 1) == '*')
                a[0][j] = true;
            else
                break;
        }

        for (int i = 1; i < s.length() + 1; i++)
            for (int j = 1; j < p.length() + 1; j++) {
                if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1))
                    a[i][j] = a[i - 1][j - 1];
                else if (p.charAt(j - 1) == '*') {
                    int k = i;
                    while (k >= 0) {
                        if (a[k][j - 1]) {
                            a[i][j] = true;
                            break;
                        }
                        --k;
                    }
                }
            }
        return a[s.length()][p.length()];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("a", "a*"));
    }
}
