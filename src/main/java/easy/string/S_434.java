package easy.string;

/**
 * @Author hunan
 * @Date 2018/5/29
 * @Time 下午10:24
 */
public class S_434 {
    public int countSegments(String s) {
        if(s==null||s.matches("\\s+")){
            return 0;
        }
        return s.split("\\s+").length;
    }

    /**
     * 效率较高 2ms
     * @param s
     * @return
     */
    public int countSegments2(String s) {
        int count = 0;
        if(s==null||s.length()==0){
            return count;
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' '&&(i==s.length()-1||s.charAt(i+1)==' ')){
                count++;
            }
        }
        return count;
    }
}
