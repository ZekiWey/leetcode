package com.zeki.letcode.questiontop25.question15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main3 {
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
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>(100);

        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i-1] == nums[i]){
                continue;
            }
            int k = nums.length - 1;
            int target = -nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if(j > i + 1 && nums[j-1] == nums[j]){
                    continue;
                }
                while (k > j && nums[j] + nums[k] > target){
                    k--;
                }
                if(k == j){
                    break;
                }
                if(nums[j] + nums[k] == target){
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                }

            }
        }
        return res;
    }
}
