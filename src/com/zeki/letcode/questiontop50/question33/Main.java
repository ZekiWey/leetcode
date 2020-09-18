package com.zeki.letcode.questiontop50.question33;

/**
 *假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * @author Zeki
 * @date 2020/9/16 17:03
 */
public class Main {

    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int index = -1;

        int start = 0;
        int end = nums.length - 1;
        int middle = nums.length / 2;
        while (start < end){
            if(nums[middle] == target){
                return middle;
            }
            if(nums[middle] > target){
                if(nums[start] < nums[middle]){
                    if(nums[start] <= target){
                        end = middle - 1;
                    }else {
                        start = middle + 1;
                    }
                }else {
                    start = start + 1;
                }
            }else {
                if(nums[end] > nums[middle]){
                    if(nums[end] >= target){
                        start = middle + 1;
                    }else {
                        end = middle - 1;
                    }
                }else {
                    end = end - 1;
                }
            }
            middle = start + (end - start) / 2;
        }
        if(middle <= nums.length - 1 && nums[middle] == target){
            return middle;
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,8,1,2,3,4,5,6 };
        int target = 2;
        System.out.println(new Main().search(nums, target));
    }
}
