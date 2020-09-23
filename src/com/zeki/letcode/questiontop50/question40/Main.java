package com.zeki.letcode.questiontop50.question40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 * @author Zeki
 * @date 2020/9/10 10:01
 */
public class Main {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        back(new ArrayList<>(),candidates,0,target,0);
        return res;
    }

    public void back(List<Integer> list,int[] candidates,int sum,int target,int begin){
        if(sum == target){
            res.add(new ArrayList<>(list));
            return;
        }
        if(sum > target){
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (i - 1 >= begin && candidates[i - 1] == candidates[i] ) {
                continue;
            }
            list.add(candidates[i]);
            sum+=candidates[i];
            back(list,candidates,sum,target,i + 1);
            sum = sum - candidates[i];
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {

        Main main = new Main();
        int[] candidates = new int[]{2,2,2,2,2,2,2,2,2,2};
        System.out.println(main.combinationSum2(candidates, 8));
    }
}
