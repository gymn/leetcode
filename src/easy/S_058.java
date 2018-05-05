package easy;

/**
 * Author:hunan07(hunan07@meituan.com)
 * Date:2018/5/3
 */
public class S_058 {
    /**
     * 暴力解法
     * 高于7.4%
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s) {
        String[] words = s.split("[^a-zA-Z]+");
        return words.length==0?0:words[words.length-1].length();
    }


    /**
     * 高于91.8%
     * @param s
     * @return
     */
    public static int lengthOfLastWord2(String s) {
        int len = 0;
        boolean flag = false;
        for(int i=s.length()-1;i>=0;i--){
            char c = s.charAt(i);
            if(!flag&&((c>='a'&&c<='z')||(c>='A'&&c<='Z'))){
                flag = true;
            }

            if(flag&&!(((c>='a'&&c<='z')||(c>='A'&&c<='Z')))){
                return len;
            }

            if(flag){
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int len = lengthOfLastWord2("hello");
        System.out.println(len);
    }
}
