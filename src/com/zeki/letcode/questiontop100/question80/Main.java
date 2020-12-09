package com.zeki.letcode.questiontop100.question80;

import java.util.Arrays;

/**
 * 删除排序数组中的重复项 II
 * 给定一个增序排列数组 nums ，你需要在 原地 删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * @author Zeki
 * @date 2020/12/5 13:35
 */
public class Main {

    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length <= 0){
            return 0;
        }
        int curNum = nums[0],count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == curNum){
                count++;
                if(count > 2){
                    nums[i] = -10001;
                }
            }else {
                curNum = nums[i];
                count = 1;
            }
        }
        int fLen = 0;
        for (int num : nums) {
            if(num != - 10001){
                nums[fLen++] = num;
            }
        }
        return fLen;
    }

    /**
     * 目前最优解
     * @param nums
     * @return
     */
    public int removeDuplicates1(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if(i < 2 || num > nums[i-2]){
                nums[i++] = num;
            }
        }

        return i;
    }



    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = new int[]{1,1,1,2,3,3,3};
        int i = main.removeDuplicates1(nums);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * go 语言实现
     * func removeDuplicates(nums []int) int {
     * 	if(len(nums) <= 0){
     * 		return 0
     *        }
     * 	curNum,count := nums[0],0
     * 	for i,num := range nums{
     * 		if(num == curNum){
     * 			count++
     * 			if(count > 2){
     * 				nums[i] = -10001
     *            }
     *        }else{
     * 			curNum = num
     * 			count = 1
     *        }
     *    }
     * 	fLen := 0
     * 	for _,num := range nums{
     * 		if(num != -10001){
     * 			nums[fLen] = num
     * 			fLen++
     *        }
     *    }
     * 	return fLen
     * }
     *
     */
}
