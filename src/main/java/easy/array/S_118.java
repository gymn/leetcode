package easy.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:hunan07(hunan07@meituan.com)
 * Date:2018/5/23
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 */
public class S_118 {
    public List<List<Integer>> generate(int numRows) {
        if(numRows==0){
            return new ArrayList<>();
        }

        List<List<Integer>> yhTriangle = new ArrayList<>();
        List<Integer> initList = new ArrayList<>();
        initList.add(1);
        yhTriangle.add(initList);

        for(int i=1;i<numRows;i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for(int j=1;j<i;j++){
                List<Integer> last = yhTriangle.get(yhTriangle.size()-1);
                list.add(last.get(j-1)+last.get(j));
            }
            list.add(1);
            yhTriangle.add(list);
        }
        return yhTriangle;
    }

    public static void main(String[] args) {
        List<List<Integer>> yhTriangle = new S_118().generate(5);
        for(List<Integer> list:yhTriangle){
            for(int n:list){
                System.out.print(n+"\t");
            }
            System.out.println();
        }
    }
}
