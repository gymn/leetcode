package easy.math;

import org.junit.Test;

import static org.junit.Assert.*;

public class S_172Test {
    @Test
    public void trailingZeroes2() throws Exception {
        S_172 s_172 = new S_172();
        int res = s_172.trailingZeroes2(25);
        System.out.println(res);
    }

    @Test
    public void trailingZeroes() throws Exception {
        S_172 s_172 = new S_172();
        int res = s_172.trailingZeroes(2147483647);
        System.out.println(res);
    }

}