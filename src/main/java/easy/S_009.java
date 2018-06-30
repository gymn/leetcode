package easy;

/**
 * Created by ad on 2017/6/6.
 */
public class S_009 {
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int len = 0;
        int tmp = x;
        while (tmp != 0) {
            tmp = tmp / 10;
            len++;
        }

        for (int i = 0; i < len / 2; i++) {
            if (x / (int) Math.pow(10, i) % 10 != x / (int) Math.pow(10, len - i - 1) % 10)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int x = -2147447412;
        System.out.println(isPalindrome(x));
    }
}
