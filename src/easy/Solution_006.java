package easy;

/**
 * Created by ad on 2017/6/3.
 */
public class Solution_006 {
    public static String convert(String s, int numRows) {
        StringBuffer res = new StringBuffer();
        StringBuffer[] sb = new StringBuffer[numRows];
        for (int i1 = 0; i1 < numRows; i1++)
            sb[i1] = new StringBuffer();

        int i = 0;
        int len = s.length();
        while (i < len) {
            for (int j = 0; j < numRows && i < len; j++)
                sb[j].append(s.charAt(i++));
            for (int k = numRows - 2; k > 0 && i < len; k--)
                sb[k].append(s.charAt(i++));
        }

        for (int k = 0; k < numRows; k++) {
            res.append(sb[k]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.printf(convert(s, 3));
    }
}
