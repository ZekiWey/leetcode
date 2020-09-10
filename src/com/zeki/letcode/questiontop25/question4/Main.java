package com.zeki.letcode.questiontop25.question4;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public static void main(String[] args) {
        int[] num1 = new int[]{1,3,5,6,7};
        int[] num2 = new int[]{2,18,32,17};
        findMedianSortedArrays(num1,num2);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double ans;
        int length1 = nums1.length,length2 = nums2.length,length3 = length1 + length2;
        int[] nums3 = new int[length3];
        int arr1Point = 0,arr2Point = 0;
        for (int i = 0; i < length3; i++) {
            if(arr2Point >= length2){
                nums3[i] = nums1[arr1Point++];
                continue;
            }
            if(arr1Point >= length1){
                nums3[i] = nums2[arr2Point++];
                continue;
            }
            if(nums1[arr1Point] > nums2[arr2Point]){
                nums3[i] = nums2[arr2Point++];
                continue;
            }
            if(nums1[arr1Point] < nums2[arr2Point]){
                nums3[i] = nums1[arr1Point++];
                continue;
            }
            if(nums1[arr1Point] == nums2[arr2Point]){
                nums3[i] = nums1[arr1Point++];
                nums3[++i] = nums2[arr2Point++];
                continue;
            }
        }
        if(length3 % 2 == 0){
            ans = (nums3[length3 / 2] + nums3[length3 / 2 - 1]) / 2d;
        }else {
            ans = nums3[length3 / 2];
        }
        return ans;
    }
}
