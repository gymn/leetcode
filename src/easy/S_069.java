package easy;

/**
 * Author:hunan07(hunan07@meituan.com)
 * Date:2018/5/5
 */

/**
 * x 的平方根
 */
public class S_069 {
    /**
     * 64ms 14.6%
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        if(x==1) return 1;
        for(int i=1;i<=x;i++){
            if(i*i>x||i*i<0){
                return i-1;
            }
        }
        return 0;
    }

    /**
     * 优化：二分法
     * 38ms 56.45%
     * @param x
     * @return
     */
    public static int mySqrt2(int x) {
        if(x==1) return 1;
        int start = 0, end = x;
        while(end>start){
            long mid = (start+end)/2;
            if(mid*mid<=x&&((mid+1)*(mid+1)>x)){
                return (int)mid;
            }else if(mid*mid>x){
                end = (int)mid;
            }else{
                start = (int)mid;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        for(int x=0;x<=100;x++){
            int a = (int)Math.sqrt(x);
            int b = mySqrt2(x);
            if(a!=b){
                System.out.println(x+" "+mySqrt2(x));
            }

            int c = (int)Math.sqrt(Integer.MAX_VALUE-x);
            int d = mySqrt2(Integer.MAX_VALUE-x);
            if(c!=d){
                System.out.println((Integer.MAX_VALUE-x)+" ");
            }
        }
    }
}
