package easy;

import java.awt.*;

/**
 * @Author hunan
 * @Date 2018/5/28
 * @Time 下午10:34
 * 矩形重叠
 */
public class S_836 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        Polygon p1 = new Polygon();
        p1.addPoint(rec1[0],rec1[1]);
        p1.addPoint(rec1[2],rec1[3]);
        p1.addPoint(rec1[0],rec1[3]);
        p1.addPoint(rec1[2],rec1[1]);
        return p1.intersects(rec2[0],rec2[1],rec2[2]-rec2[0],rec2[3]-rec2[1]);
    }

    public static void main(String[] args) {

    }
}
