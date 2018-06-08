package easy.math;

/**
 * @Author hunan
 * @Date 2018/5/28
 * @Time 下午10:57
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 */
public class S_326 {
    public boolean isPowerOfThree(int n) {
        if(n==0) {
            return false;
        }
        while(n%3==0){
            n/=3;
        }
        return n==1;
    }
}
