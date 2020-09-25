package com.zeki.letcode.questiontop50.question46;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * @author Zeki
 * @date 2020/9/24 9:50
 */
public class Main {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        back(nums,new ArrayList<>(),res,0);
        return res;
    }

    private void back(int[] nums,List<Integer> list,List<List<Integer>> res,int begin){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(list.contains(nums[j])){
                    continue;
                }
                list.add(nums[j]);
                back(nums,list,res,i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = new int[]{1,2,3};
        System.out.println(main.permute(nums));
    }
}
