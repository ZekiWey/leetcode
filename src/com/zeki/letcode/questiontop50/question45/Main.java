package com.zeki.letcode.questiontop50.question45;

/**
 * @author Zeki
 * @date 2020/9/23 15:57
 */
public class Main {


    /**
     * 贪心算法 从终点反向查找
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int count = 0;
        int end = nums.length - 1;
        while (end > 0){
            int i = 0;
            for (;i < nums.length; i++) {
                if(i + nums[i] >= end){
                    end = i;
                    count++;
                    break;
                }
            }
            if(i >= nums.length){
                end = end -1;
                count++;
            }
        }
        return count;
    }

    /**
     * 贪心算法 正向查找
     * @param nums
     * @return
     */
    public int jump1(int[] nums) {
        //2,3,1,1,4
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    private int min = -1;
    /**
     * 回溯算法 超时
     * @param nums
     * @return
     */
    public int jump2(int[] nums) {
        back(nums,0,0);
        return min;
    }

    /**
     * 回溯算发
     * @param nums
     * @param begin
     * @param count
     */
    private void back(int[] nums,int begin,int count){
        if(begin > nums.length - 1){
            return;
        }
        if(begin == nums.length - 1){
            if(min == -1 || count < min){
                min = count;
                return;
            }
        }
        if(min != -1 && count >= min){
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            int maxStep = nums.length - begin - 1;
            maxStep = maxStep > nums[begin] ? nums[begin] : maxStep;
            for (int j = maxStep; j >= 1; j--) {
                back(nums,begin + j,count + 1);
            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = new int[]{2,3,1,1,4};
        int[] nums1 = new int[]{4,1,1,3,1,1,1};

        System.out.println(main.jump1(nums));
    }
}
