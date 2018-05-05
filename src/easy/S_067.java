package easy;

/**
 * Author:hunan07(hunan07@meituan.com)
 * Date:2018/5/4
 */

/**
 * 二进制求和
 */
public class S_067 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int alen = a.length();
        int blen = b.length();
        int minLen = alen<blen?alen:blen;

        int carry = 0;
        for(int i=0; i<minLen; i++){
            int val = a.charAt(alen-i-1)-'0'+b.charAt(blen-i-1)-'0'+carry;
            if(val > 1){ //进位
                sb.append(val%2);
                carry = 1;
            }else{
                sb.append(String.valueOf(val));
                carry = 0;
            }

        }

        if(alen>blen){
            for(int i=minLen; i<alen; i++){
                int val = a.charAt(alen-i-1)-'0'+carry;
                if(val > 1){
                    sb.append(val%2);
                    carry = 1;
                }else{
                    sb.append(String.valueOf(val));
                    carry = 0;
                }
            }
        }else{
            for(int i=minLen; i<blen; i++){
                int val = b.charAt(blen-i-1)-'0'+carry;
                if(val > 1){
                    sb.append(val%2);
                    carry = 1;
                }else{
                    sb.append(String.valueOf(val));
                    carry = 0;
                }
            }
        }

        if(carry==1){
            sb.append("1");
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        S_067 s_067 = new S_067();
        System.out.println(s_067.addBinary("11","11"));
    }
}
