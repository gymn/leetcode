package easy.string;

/**
 * @Author hunan
 * @Date 2018/5/27
 * @Time 下午11:10
 * 验证回文串
 */
public class S_125 {
    /**
     * 效率较低
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(String.valueOf(s.charAt(i)).matches("[a-zA-Z0-9]")){
                sb.append(s.charAt(i));
            }
        }

        String s1 = sb.toString().toLowerCase();
        String s2 = sb.reverse().toString().toLowerCase();
        return s1.equals(s2);
    }
}
