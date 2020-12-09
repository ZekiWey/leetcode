package com.zeki.letcode.questiontop100.question78;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 输入: nums = [1,2,3]
 * 输出:
 *
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * @author Zeki
 * @date 2020/11/28 10:54
 */
public class Main {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tempList = new ArrayList<>();



    public List<List<Integer>> subsets(int[] nums) {
        dfs(0,nums);
        return res;
    }

    private void dfs(int i,int[] nums){
        res.add(new ArrayList<>(tempList));

        for (int j = i; j < nums.length; j++) {
            tempList.add(nums[j]);
            dfs(j + 1, nums);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        List<List<Integer>> subsets = main.subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }

}
