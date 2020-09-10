package com.zeki.letcode.questiontop25.question15;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        //int[] nums = new int[]{-1, 0};
        System.out.println(threeSum(nums));
    }

    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 
     * 中是否存在三个元素 a，b，c ，
     * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(100);
        if(nums == null || nums.length <= 0){
            return res;
        }
        if(nums.length <= 3){
            if(nums.length == 3){
                if(nums[0] + nums[1] + nums[2] != 0){
                    return res;
                }else {
                    res.add(Arrays.asList(nums[0],nums[1],nums[2]));
                    return res;
                }
            }else {
                return res;
            }
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if(j > i + 1 && nums[j] == nums[j-1]){
                    continue;
                }
                for (int k = j + 1; k < nums.length; k++) {
                    if(k > j + 1 && nums[k] == nums[k-1]){
                        continue;
                    }
                    if(nums[i] + nums[j] + nums[k] == 0){
                        res.add(Arrays.asList(nums[i] ,nums[j] ,nums[k]));
                    }
                }
            }
        }
        return res;
    }
}
