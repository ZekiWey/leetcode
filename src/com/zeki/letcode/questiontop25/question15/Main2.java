package com.zeki.letcode.questiontop25.question15;

import java.util.*;

public class Main2 {
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
        List<List<Integer>> res = new ArrayList<>(16);
        //分成3个map 负数 0 正数
        Map<Integer,Integer> lessMap = new HashMap<>(nums.length);
        Map<Integer,Integer> zeroMap = new HashMap<>(nums.length);
        Map<Integer,Integer> moreMap = new HashMap<>(nums.length);
        Map<Integer,Integer> tempMap;
        for (int num : nums) {
            tempMap = num == 0 ? zeroMap : num > 0 ? moreMap : lessMap;
            Integer integer = tempMap.get(num);
            if(integer == null){
                tempMap.put(num,1);
            }else {
                tempMap.put(num,++integer);
            }
        }
        HashMap<String,Boolean> resMap = new HashMap<>(100);
        for (int i = 0; i < nums.length; i++) {
            if( i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if(j > i + 1 && nums[j] == nums[j-1]){
                    continue;
                }
                int sum = nums[i] + nums[j];
                int targetNum = sum == 0 ? 0 : -sum;
                tempMap = sum == 0 ? zeroMap : sum > 0 ? lessMap : moreMap;
                Integer integer = tempMap.get(targetNum);
                int existThree = 0;
                if(integer != null){
                    //判断sumi sumj 是否与这个数相同
                    if(nums[i] == targetNum){
                        existThree++;
                    }
                    if(nums[j] == targetNum){
                        existThree++;
                    }
                    if(integer > existThree){
                        //说明组成了这个数 判重后插入二维数组
                        if(checkIJK(resMap,nums[i] ,nums[j] ,targetNum)){
                            resMap.put(String.format(FORMAT,nums[i] ,nums[j] ,targetNum),true);
                        }
                    }
                }
            }
        }

        for (String s : resMap.keySet()) {
            String[] split = s.split(":");
            res.add(Arrays.asList(Integer.parseInt(split[0]),Integer.parseInt(split[1]),Integer.parseInt(split[2])));
        }

        return res;
    }

    public static final String FORMAT = "%d:%d:%d";
    private static boolean checkIJK(HashMap<String,Boolean> map,int i,int j,int k){
        String s = String.format(FORMAT,i,j,k);
        if(map.get(s) != null){
            return false;
        }

        s = String.format(FORMAT,i,k,j);
        if(map.get(s) != null){
            return false;
        }

        s = String.format(FORMAT,j,i,k);
        if(map.get(s) != null){
            return false;
        }

        s = String.format(FORMAT,j,k,i);
        if(map.get(s) != null){
            return false;
        }

        s = String.format(FORMAT,k,j,i);
        if(map.get(s) != null){
            return false;
        }

        s = String.format(FORMAT,k,i,j);
        if(map.get(s) != null){
            return false;
        }
        return true;
    }
}
