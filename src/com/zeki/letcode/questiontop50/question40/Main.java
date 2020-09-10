package com.zeki.letcode.questiontop50.question40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zeki
 * @date 2020/9/10 10:01
 */
public class Main {

    /**
     * 回溯 》 动态规划
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> res = new ArrayList<>();

        backtrack(res,new ArrayList<>(),0,candidates,target);

        return res;
    }


    private void backtrack(List<List<Integer>> res,List<Integer> indexList,int sum,int[] candidates,int target){
        if(sum >= target){
            if(sum == target){
                List<Integer> ans = new ArrayList<>(indexList.size());
                for (Integer integer : indexList) {
                    ans.add(candidates[integer]);
                }
                res.add(ans);
            }
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            if(indexList.contains(i)){
                continue;
            }
            indexList.add(i);
            sum = sum + candidates[i];
            backtrack(res,indexList,sum,candidates,target);
            indexList.remove(indexList.size() - 1);
            sum = sum - candidates[i];
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        /*int[] candidates = new int[]{2,5,2,1,2};
        int target = 5;*/
        System.out.println(new Main().combinationSum2(candidates, target));
    }
}
