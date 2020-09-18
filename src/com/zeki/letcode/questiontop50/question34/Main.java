package com.zeki.letcode.questiontop50.question34;

import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * @author Zeki
 * @date 2020/9/18 15:05
 */
public class Main {

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target){
                if(res[0] == -1){
                    res[0] = i;
                    res[1] = i;
                }else {
                    res[1] = i;
                }
            }
            if(nums[i] > target){
                break;
            }
        }
        return res;
    }

    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange1(int[] nums, int target) {
        int middle;
        int l = 0,r = nums.length - 1;
        int findIndex = -1;
        while (l <= r){
            middle = (l + r) / 2;
            if(nums[middle] == target){
                findIndex = middle;
                break;
            }
            if(nums[middle] < target){
                l = middle + 1;
            }else {
                r = middle - 1;
            }
        }
        int[] res = new int[]{-1,-1};
        if(findIndex != -1){
            res[0] = findIndex;
            res[1] = findIndex;
            //向左查找
            int i = findIndex - 1;
            while (i >=0 && nums[i] == target){
                res[0] = i;
                i--;
            }
            //向右查找
            i = findIndex + 1;
            while (i < nums.length && nums[i] == target){
                res[1] = i;
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7};
        int target = 8;
        System.out.println(Arrays.toString(new Main().searchRange1(nums, target)));
    }
}
