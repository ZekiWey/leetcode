package com.zeki.letcode.questiontop50.question41;

/**
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * 输入: [1,2,0]
 * 输出: 3
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 * @author Zeki
 * @date 2020/9/22 10:50
 */
public class Main {

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] <= 0) {
                nums[i] = nums.length + 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int abs = Math.abs(nums[i]);
            if(abs <= nums.length){
                nums[abs - 1] = nums[abs - 1] < 0 ? nums[abs - 1] : -nums[abs - 1];
            }
        }
        int i = 0;
        for (; i < nums.length; i++) {
            if(nums[i] > 0){
                break;
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,10,5,3,1,2,-1,19};
        Main main = new Main();
        System.out.println(main.firstMissingPositive(nums));
    }

    //3,2,1,9,11,12
    //2,1,0,8,10,11
}
