package easy;

/**
 * Author:hunan07(hunan07@meituan.com)
 * Date:2018/5/7
 */
public class S_070 {
    /**
     *  超时
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        return climbStairs(n-1)+climbStairs(n-2);
    }

    /**
     * 斐波那契数列 80.7%
     * @param n
     * @return
     */
    public static int climbStairs2(int n) {
        int a = 0, b=1;
        for(int i=0;i<n;i++){
            int tmp = b;
            b = a+b;
            a = tmp;
        }
        return b;
    }
    public static void main(String[] args) {
        System.out.println(climbStairs2(5));
    }
}
