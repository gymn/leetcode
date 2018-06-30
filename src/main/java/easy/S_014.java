package easy;

/**
 * Created by ad on 2017/8/1.
 */
public class S_014 {
    /**
     * Write a function to find the longest common prefix string amongst an array of strings.
     */
    public static String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0)
            return "";
        if(strs.length==1)
            return strs[0];

        StringBuilder sb = new StringBuilder();
        String str = strs[0];
        for(String s: strs)
            if(s.length()<str.length())
                str = s;

        char[] ca = str.toCharArray();
        for(int i=0;i<ca.length;i++) {
            for (int j = 0; j < strs.length; j++)
                if (strs[j].charAt(i) != ca[i])
                    return sb.toString();
            sb.append(ca[i]);
        }
       return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"aa","a"};
        System.out.println(longestCommonPrefix(strs));
    }
}
