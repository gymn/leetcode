package easy.math;

/**
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 */
public class S_172 {
    /**
     * o(n) 超时
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int countZero = 0;
        int product = 5;
        for (int i = 1; product <= n; i++, product *= i) {
            countZero++;
            if (i % 5 == 0) {
                int tmp = i;
                while (tmp % 5 == 0) {
                    tmp /= 5;
                    countZero++;
                }
            }
            product = 5;
        }

        return countZero;
    }


    public int trailingZeroes2(int n) {
        int base = 5;
        int countZero = 0;
        while (n >= 5) {
            n /= base;
            countZero += n;
        }

        return countZero;
    }
}
