package easy;

/**
 * Created by ad on 2017/6/5.
 */
public class S_008 {
    public static int myAtoi(String str) {
        boolean negative = false;

        char[] num = str.trim().toCharArray();
        long res = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] == '-' && i == 0) {
                negative = true;
                continue;
            } else if (num[i] == '+' && i == 0) {
                continue;
            }
            if (num[i] < '0' || num[i] > '9')
                break;
            res = res * 10 + (num[i] - '0');
            if (!negative && res > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (negative && res * -1 < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }

        return negative ? (int) res * -1 : (int) res;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-99999999999999999999"));
    }
}
