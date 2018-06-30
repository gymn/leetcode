package easy.math;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author hunan
 * @Date 2018/6/30
 * @Time 下午4:35
 */
public class S_168Test {

    @Test
    public void convertToTitle() {
        S_168 s_168 = new S_168();
        assertEquals(s_168.convertToTitle(1),"A");
        assertEquals(s_168.convertToTitle(26),"Z");
        assertEquals(s_168.convertToTitle(27),"AA");
        assertEquals(s_168.convertToTitle(703),"AAA");
        assertEquals(s_168.convertToTitle(18279),"AAAA");
        System.out.println(s_168.convertToTitle(1000000001));
    }
}