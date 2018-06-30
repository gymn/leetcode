package easy.math;

/**
 * @Author hunan
 * @Date 2018/6/30
 * @Time 下午4:09
 * Excel表列名称
 */
public class S_168 {
    public String convertToTitle(long n) {
        if (n == 0) {
            return "";
        }
        long top = 0;
        long index = 0;
        while (n > top) {
            top = top + (long) Math.pow(26, ++index);
        }

        long base = (long) Math.pow(26, index - 1);

        if (base != 1 && n % base == 0) {
            return String.valueOf((char) (n / base - 2 + 'A')) + convertToTitle(n - base * (n / base - 1));
        }
        return String.valueOf((char) ((n / base) - 1 + 'A')) + convertToTitle(n % base);
    }
}
