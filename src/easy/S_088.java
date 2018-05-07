package easy;

/**
 * Author:hunan07(hunan07@meituan.com)
 * Date:2018/5/7
 */

/**
 * 合并两个有序数组
 */
public class S_088 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = new int[m+n];
        for(int i=0,j=0,k=0;i<m||j<n;k++){
            if(i>=m){
                tmp[k] = nums2[j++];
                continue;
            }
            if(j>=n){
                tmp[k] = nums1[i++];
                continue;
            }
            if(nums1[i]<nums2[j]){
                tmp[k] = nums1[i];
                i++;
            }else{
                tmp[k] = nums2[j];
                j++;
            }
        }
        for(int i=0; i<tmp.length; i++){
            nums1[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1,3,nums2,3);
    }
}
