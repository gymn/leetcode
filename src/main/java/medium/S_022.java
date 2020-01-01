package medium;

import java.util.ArrayList;
import java.util.List;

public class S_022 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        recur(n,n*2, result,"");
        return result;
    }
    private boolean valid(String s,int n) {
        int leftCount = 0;
        int rightCount = 0;
        for (char c : s.toCharArray()) {
            if(c=='('){
                leftCount++;
            } else {
                rightCount++;
            }
            if(rightCount>leftCount){
                return false;
            }
            if(leftCount>n) {
                return false;
            }
        }
        return true;
    }
    private void recur(int n,int index, List<String> result, String s){
        if(index==1) {
            if(valid(s,n)) {
                result.add(s+")");
            }
        } else {
            if(valid(s,n)){
                recur(n,index-1, result, s+")");
                recur(n,index-1,result,s+"(");
            }
        }
    }

    public static void main(String[] args) {
        new S_022().generateParenthesis(0).forEach(System.out::println);
    }
}
