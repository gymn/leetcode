package medium;

import java.util.ArrayList;
import java.util.List;

public class S_017 {
    String[][] keys = {{},{},{"a","b","c"},{"d","e","f"},{"g","h","i"},{"j","k","l"},{"m","n","o"},{"p","q","r","s"},{"t","u","v"},{"w","x","y","z"}};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits==null||digits.equals("")){
            return result;
        }
        recur(result, digits, "", 0);
        return result;
    }

    private void recur(List<String> result, String digits, String tmp, int index){
        if(index==digits.length()-1) {
            for (String s : keys[digits.charAt(index)-'0']) {
                result.add(tmp+s);
            }
        } else {
            for (String s : keys[digits.charAt(index)-'0']) {
                recur(result, digits, tmp+s,index+1);
            }
        }
    }

    public static void main(String[] args) {
        new S_017().letterCombinations("2").forEach(System.out::println);
    }
}
