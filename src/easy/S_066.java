package easy;

/**
 * Author:hunan07(hunan07@meituan.com)
 * Date:2018/5/3
 */
public class S_066 {
    public static int[] plusOne(int[] digits) {
        int[] newDigits = new int[digits.length];
        int carry = 0;

        for(int i=digits.length-1; i>=0; i--){
            int num = digits[i];
            if(i==digits.length-1){
                if(num==9){
                    carry = 1;
                    num = 0;
                }else{
                    num++;
                }
            }else {
                if (digits[i] + carry == 10) {
                    carry = 1;
                    num = 0;
                }else{
                    num += carry;
                    carry = 0;
                }
            }
             newDigits[i] = num;
        }
        if(carry==0) {
            return newDigits;
        }else{
            int[] res = new int[digits.length+1];
            System.arraycopy(newDigits,0,res,1,digits.length);
            res[0] = 1;
            return res;
        }
    }

    public static void main(String[] args) {
        int[] res = plusOne(new int[]{9,9});
        for(int n: res){
            System.out.print(n);
        }
        System.out.println();
    }
}
