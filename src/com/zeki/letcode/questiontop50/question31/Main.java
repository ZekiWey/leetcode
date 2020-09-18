package com.zeki.letcode.questiontop50.question31;

import java.util.Arrays;

/**
 * 31.实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * @author Zeki
 * @date 2020/9/14 10:03
 */
public class Main {

    public void nextPermutation(int[] nums) {
        //遍历查找插入的位置
        int insIndex = -1,insVal = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] < nums[i + 1]){
                insIndex = i;
                insVal = nums[i];
            }
        }
        if(insIndex == -1){
            Arrays.sort(nums);
            return;
        }
        //查找比insVal大的最小值和下标
        int min = nums[insIndex + 1],minIndex = insIndex + 1;
        for (int i = insIndex + 2; i < nums.length; i++) {
            if(nums[i] > insVal && nums[i] < min){
                min = nums[i];
                minIndex = i;
            }
        }
        //交换元素
        int temp = nums[insIndex];
        nums[insIndex] = nums[minIndex];
        nums[minIndex] = temp;
        //从小到达排序insIndex之后的元素
        for (int i = insIndex + 1; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[j] < nums[i]){
                    //交换
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public void nextPermutation1(int[] nums) {
        //遍历查找插入的位置
        int insIndex = -1,insVal = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if(nums[i-1] < nums[i]){
                insIndex = i - 1;
                insVal = nums[i - 1];
                break;
            }
        }
        if(insIndex == -1){
            Arrays.sort(nums);
            return;
        }
        //查找比insVal大的最小值和下标
        int minIndex = nums.length - 1;
        for (int i = nums.length - 1; i > insIndex; i--) {
            if(nums[i] > insVal){
                minIndex = i;
                break;
            }
        }
        //交换元素
        int temp = nums[insIndex];
        nums[insIndex] = nums[minIndex];
        nums[minIndex] = temp;
        //逆序insIndex之后的元素
        reverse(nums,insIndex + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3};
        int[] nums2 = new int[]{3,2,1};
        int[] nums3 = new int[]{1,1,3,3,2};
        int[] nums4 = new int[]{3,5,8,7,6,4};
        new Main().nextPermutation1(nums1);
        System.out.println(Arrays.toString(nums1));
    }
}
