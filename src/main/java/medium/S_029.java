package medium;

import org.junit.Test;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 示例 1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 说明:
 * <p>
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 */
public class S_029 {
    public int divide(int dividend, int divisor) {
        int dividendAbs = dividend > 0 ? 0 - dividend : dividend;
        int divisorAbs = divisor > 0 ? 0 - divisor : divisor;
        int count = 0;
        for (int i = 31; i >= 0; i--) {
            while (dividendAbs >> i <= divisorAbs) {
                count -= (1 << i);
                dividendAbs -= divisorAbs << i;
            }
        }

        boolean positiveResult = dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0;
        if (positiveResult) {
            return count == Integer.MIN_VALUE ? Integer.MAX_VALUE : 0 - count;
        } else {
            return count;
        }
    }

    @Test
    public void testDivide() {
        System.out.println(divide(10, 3));
    }


}
