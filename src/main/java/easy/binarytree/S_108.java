package easy.binarytree;

import util.TreeNode;

import java.util.Arrays;

/**
 * Author:hunan07(hunan07@meituan.com)
 * Date:2018/5/21
 */

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 */
public class S_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null || nums.length==0){
            return null;
        }
        if(nums.length==1)
            return new TreeNode(nums[0]);

        int index = nums.length/2;
        int value = nums[index];
        TreeNode node = new TreeNode(value);
        if(index>0){
            node.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,index));
        }
        if(index<nums.length-1){
            node.right = sortedArrayToBST(Arrays.copyOfRange(nums,index+1,nums.length));
        }
        return node;
    }
}
