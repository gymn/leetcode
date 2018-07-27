package easy.math;

/**
 * @Author hunan
 * @Date 2018/7/26
 * @Time 下午9:10
 */
public class S_171 {
    public int titleToNumber(String s) {
        int sum = 0;
        int base = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            sum += (s.charAt(i) - 'A' + 1) * base;
            base *= 26;
        }
        return sum;
    }
}
