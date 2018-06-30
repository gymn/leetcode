package easy.array;

import java.util.Arrays;
import java.util.List;

/**
 * @Author hunan
 * @Date 2018/5/24
 * @Time 下午10:41
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 */
public class S_119 {
    public List<Integer> getRow(int rowIndex) {
        Integer[] arr = new Integer[rowIndex + 1];
        Integer[] helper = new Integer[rowIndex + 1];
        arr[0] = 1;
        if(rowIndex==0) {
            return Arrays.asList(arr);
        }

        arr[1] = 1;
        if(rowIndex==1){
            return Arrays.asList(arr);
        }

        for (int i = 2; i < arr.length; i++) {
            System.arraycopy(arr,0,helper,0,arr.length);
            for(int j=1; j<i; j++){
                arr[j] = helper[j-1]+helper[j];
            }
            arr[i] = 1;
        }

        return Arrays.asList(arr);
    }
}
