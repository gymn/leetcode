package hard;

import org.junit.Test;

public class S_004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        for (int i = 0, i1 = 0, i2 = 0; i < nums.length; i++) {
            if (i1 == nums1.length) {
                nums[i] = nums2[i2];
                i2++;
            } else if (i2 == nums2.length) {
                nums[i] = nums1[i1];
                i1++;
            } else if (nums1[i1] <= nums2[i2]) {
                nums[i] = nums1[i1];
                i1++;
            } else {
                nums[i] = nums2[i2];
                i2++;
            }
        }

        if (nums.length % 2 == 0) {
            return (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2.0;
        }

        return nums[nums.length / 2];
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int ti = (nums1.length + nums2.length) / 2;
        int n1 = 0, n2 = 0;
        for (int i = 0, j = 0, k = 0; i < nums1.length + nums2.length; i++) {
            int v;
            if (k == nums2.length) {
                v = nums1[j];
                j++;
            } else if (j == nums1.length) {
                v = nums2[k];
                k++;
            } else if (nums1[j] <= nums2[k]) {
                v = nums1[j];
                j++;
            } else {
                v = nums2[k];
                k++;
            }

            if (i == ti - 1) {
                n1 = v;
            }

            if (i == ti) {
                n2 = v;
                break;
            }
        }

        if ((nums1.length + nums2.length) % 2 == 0) {
            return (n1 + n2) / 2.0;
        } else {
            return n2;
        }
    }


    @Test
    public void test() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays2(nums1, nums2));
    }
}
