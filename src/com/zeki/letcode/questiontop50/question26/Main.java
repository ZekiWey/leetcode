package com.zeki.letcode.questiontop50.question26;

import java.util.Arrays;

/**
 * @author Zeki
 * @date 2020/9/8 16:57
 */
public class Main {

    public int removeDuplicates(int[] nums) {
        int delNum = 0;
        int temp = 0;
        for (int i = 0; i < nums.length - delNum; i++) {
            for (int j = i + 1; j < nums.length - delNum; j++) {
                if(nums[i] == nums[j]){
                    //从数组后边查找第一个不一样的元素
                    int n = nums.length - delNum - 1;
                    while (nums[n] == nums[i] && n >= j + 1){
                        delNum++;
                        n--;
                    }
                    temp = nums[nums.length - delNum - 1];
                    nums[nums.length - delNum - 1] = nums[j];
                    nums[j] = temp;
                    delNum++;
                }
            }
        }
        //排序
        for (int i = 0; i < nums.length - delNum - 1; i++) {
            for (int j = i + 1; j < nums.length - delNum; j++) {
                if(nums[j] < nums[i]){
                    temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return nums.length - delNum;
    }

    /**
     * 利用有序数组
     * @param nums
     * @return
     */
    public int removeDuplicates1(int[] nums) {
        int delNum = 0;
        int currentDuplNums = 0;
        for (int i = 0; i < nums.length - delNum; i++) {
            for (int j = i + 1; j < nums.length - delNum; j++) {

                if(nums[i] == nums[j]){
                    //找出当前有几个重复的
                    currentDuplNums = 0;
                    int n = j;
                    while (n < nums.length - delNum && nums[n] == nums[i]){
                        currentDuplNums++;
                        n++;
                    }
                    for (int k = n; k < nums.length - delNum; k++) {
                        //将这些数据往前搬移currentDuplNums位
                        nums[k-currentDuplNums] = nums[k];
                    }
                    delNum+=currentDuplNums;
                }

            }
        }
        return nums.length - delNum;
    }

    /**
     * 利用有序数组
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        int delNum = 0;
        int currentDuplNums = 0;
        for (int i = 0; i < nums.length - delNum - 1; i++) {
            if(nums[i] == nums[i + 1]){
                //找出当前有几个重复的
                currentDuplNums = 0;
                int n = i + 1;
                while (n < nums.length - delNum && nums[n] == nums[i]){
                    currentDuplNums++;
                    n++;
                }
                for (int k = n; k < nums.length - delNum; k++) {
                    //将这些数据往前搬移currentDuplNums位
                    nums[k-currentDuplNums] = nums[k];
                }
                delNum+=currentDuplNums;
            }
        }
        return nums.length - delNum;
    }

    /**
     * 双指针
     * @param nums
     * @return
     */
    public int removeDuplicates3(int[] nums) {
        int left = 0;
        int right = 0;
        while (++right < nums.length){
            if(nums[left] != nums[right]){
                nums[++left] = nums[right];
            }
        }
        return left + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,3,4,4,5,5,5,5,6};
        System.out.println(new Main().removeDuplicates3(nums));
        System.out.println(Arrays.toString(nums));
    }


}
