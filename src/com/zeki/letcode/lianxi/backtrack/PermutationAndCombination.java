package com.zeki.letcode.lianxi.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * N个不重复的数组排列组合
 * @author Zeki
 * @date 2020/9/7 17:13
 */
public class PermutationAndCombination {


    /**
     * 采用回溯算法实现
     * @param nums 整数数组
     * @return
     */
    public List<List<Integer>> permutationAndCombination(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        backtrack(new ArrayList<Integer>(),res,nums,nums.length,0);
        return res;
    }

    public void backtrack(List<Integer> list,List<List<Integer>> res,int[] nums,int n,int index){
        if(n == index){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            backtrack(list,res,nums,n,index + 1);
            list.remove(index);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(new PermutationAndCombination().permutationAndCombination(nums));
    }
}
