package medium;

/**
 * Author:hunan07(hunan07@meituan.com)
 * Date:2018/5/4
 */
public class S_011 {
    /**
     * 暴力解法，超时。。。
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int maxVal = 0;
        for(int i=0; i<height.length; i++){
            for(int j=i+1; j<height.length; j++){
                int area = (j-i)*Math.min(height[i],height[j]);
                if(area>maxVal){
                    maxVal = area;
                }
            }
        }
        return maxVal;
    }

    /**
     * 优化解法 11ms,49.58%
     * @param height
     * @return
     */
    public int maxArea2(int[] height){
        if(height.length<2)
            return 0;

        int i=0;
        int j = height.length-1;
        int maxArea = Integer.MIN_VALUE;
        while(i<j){
            maxArea = Math.max(maxArea, (j-i)*(Math.min(height[i],height[j])));
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }
        return maxArea;
    }

    /**
     * 再次优化，避免每次判断最大面积
     * 9ms 76.14%
     * @param height
     * @return
     */
    public int maxArea3(int[] height){
        if(height.length<2)
            return 0;

        int i=0;
        int j = height.length-1;
        int h = Math.min(height[i],height[j]);
        int maxArea = (j-i)*(Math.min(height[i],height[j]));
        while(i<j){
            if(height[i]<height[j]){
                i++;
                if(height[i]>h){
                    maxArea = Math.max(maxArea, (j-i)*(Math.min(height[i],height[j])));
                    h = Math.min(height[i],height[j]);
                }
            }else{
                j--;
                if(height[j]>h){
                    maxArea = Math.max(maxArea, (j-i)*(Math.min(height[i],height[j])));
                    h = Math.min(height[i],height[j]);
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        S_011 s_011 = new S_011();
        int[] arr  = {10,9,8,7,6,5,4,3,2,1};
        int res = s_011.maxArea3(arr);
        System.out.println(res);
    }
}
