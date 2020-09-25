package com.zeki.letcode.questiontop50.question47;

import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 * @author Zeki
 * @date 2020/9/25 14:35
 */
public class Main {

    public List<List<Integer>> permuteUnique(int[] nums) {
        //todo
        return null;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = new int[]{1,2,3};
        System.out.println(main.permuteUnique(nums));
    }
}
