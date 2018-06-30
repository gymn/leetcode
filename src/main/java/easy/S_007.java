package easy;

/**
 * Created by ad on 2017/6/5.
 */
public class S_007 {
    private static int reverse(int x) {
        long tmp = 0;
        while (x != 0) {
            tmp = tmp * 10 + x % 10;
            x /= 10;
            if (tmp > Integer.MAX_VALUE || tmp < Integer.MIN_VALUE)
                return 0;
        }


        return (int) tmp;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }
}
