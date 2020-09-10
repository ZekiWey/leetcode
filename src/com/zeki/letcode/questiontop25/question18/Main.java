package com.zeki.letcode.questiontop25.question18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zeki
 * @date 2020/9/7 12:43
 */
public class Main {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if(j > i + 1 && nums[j] == nums[j-1]){
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                //int targetSum = target - (nums[i] + nums[j]);
                while (left < right ){
                    if(nums[i] + nums[j] + nums[left] + nums[right] > target){
                        right--;
                    }else if(nums[i] + nums[j] + nums[left] + nums[right] < target){
                        left++;
                    }else {
                        res.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        //去重复元素
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        right--;
                        left++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        System.out.println(new Main().fourSum(nums,0));
    }
}
