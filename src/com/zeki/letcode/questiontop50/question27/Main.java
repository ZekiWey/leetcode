package com.zeki.letcode.questiontop50.question27;

import java.util.Arrays;

/**
 * @author Zeki
 * @date 2020/9/8 18:16
 */
public class Main {
    public int removeElement(int[] nums, int val) {
        int delNum = 0;
        for (int i = 0; i < nums.length - delNum; i++) {
            if(nums[i] == val){
                delNum++;
                nums[i] = nums[nums.length - delNum];
                if(nums[i] == val){
                    i--;
                }
            }
        }
        return nums.length - delNum;
    }

    public int removeElement1(int[] nums, int val) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                nums[num++] = nums[i];
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        System.out.println(new Main().removeElement1(nums,3));
        System.out.println(Arrays.toString(nums));
    }
}
