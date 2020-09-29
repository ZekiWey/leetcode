package com.zeki.letcode.questiontop100.question53;

/**
 * @author Zeki
 * @date 2020/9/28 11:13
 */
public class Main {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int tempSum = nums[i];
            if(tempSum > maxSum){
                maxSum = tempSum;
            }
            for (int j = i + 1; j < nums.length; j++) {
                tempSum = tempSum + nums[j];
                if(tempSum > maxSum){
                    maxSum = tempSum;
                }
            }
        }
        return maxSum;
    }

    public int maxSubArray1(int[] nums) {
        int maxSum = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        maxSum = sum;
        for (int i = 0; i < nums.length; i++) {
            //减去第一个
            int tempSum1 = sum - nums[0];
            if(tempSum1 > maxSum){
                maxSum = tempSum1;
            }
            //减去最后一个
            int tempSum2 = sum - nums[nums.length-i];
            if(tempSum2 > maxSum){
                maxSum = tempSum2;
            }

        }
        //

        for (int i = 0; i < nums.length; i++) {
            int tempSum = nums[i];
            if(tempSum > maxSum){
                maxSum = tempSum;
            }
            for (int j = i + 1; j < nums.length; j++) {
                tempSum = tempSum + nums[j];
                if(tempSum > maxSum){
                    maxSum = tempSum;
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = new int[]{1,2};
        System.out.println(main.maxSubArray(nums));
    }

    /**
     * 1,-3,4,-1,2    s5
     * 1,-3,4,-1      s4
     * 1,-3,4         s3
     * 1,-3           s2
     * 1              s1
     *
     * -3,4,-1,2      s5-s1
     * -3,4,-1        s4-s1
     * -3,4           s3-s1
     * -3             s2-s1
     *
     * 4,-1,2
     * 4,-1
     * 4
     *
     * -1,2
     * -1
     *
     * 2
     *
     */
}
