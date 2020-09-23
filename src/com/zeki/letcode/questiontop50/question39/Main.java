package com.zeki.letcode.questiontop50.question39;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * 提示
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 * @author Zeki
 * @date 2020/9/22 10:01
 */
public class Main {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            list.add(candidates[i]);
            sum+=candidates[i];
            back(list,candidates,sum,target,i);
            sum = sum - candidates[i];
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] candidates = new int[]{2,3,6,7};
        System.out.println(main.combinationSum(candidates, 7));
    }
}
