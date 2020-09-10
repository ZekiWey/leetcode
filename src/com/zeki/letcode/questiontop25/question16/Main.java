package com.zeki.letcode.questiontop25.question16;

import java.util.Arrays;

/**
 * @author Zeki
 * @date 2020/9/7 9:01
 */
public class Main {
    /**
     * 排序 + 双指针
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        int resInterval = Math.abs(target - res);

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                int tempRes = nums[i] + nums[left] + nums[right];
                int tempResInterval = Math.abs(target - tempRes);
                if(tempResInterval < resInterval){
                    res = tempRes;
                    resInterval = tempResInterval;
                }
                if(tempRes > target){
                    right--;
                }else if(tempRes < target){
                    left++;
                }else {
                    return tempRes;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,2,1,-4};
        int target = 1;
        System.out.println(new Main().threeSumClosest(nums,target));
    }
}
