package com.zeki.letcode.questiontop100.question81;

/**
 * 81. 搜索旋转排序数组 II
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * @author Zeki
 * @date 2020/12/5 14:40
 */
public class Main {
    public static void main(String[] args) {

        Main main = new Main();
        int[] nums = new int[]{2,5,6,0,0,1,2};
        System.out.println(main.search(nums, 0));
    }
    public boolean search(int[] nums, int target) {

        return search1(nums, target) != -1;
    }

    public int search1(int[] nums, int target) {
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
}
