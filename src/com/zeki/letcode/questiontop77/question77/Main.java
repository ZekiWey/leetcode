package com.zeki.letcode.questiontop77.question77;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *输入 4 ， 2
 *输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 *]
 *
 * 1，2，3，4
 *
 * 1
 * 2
 * 3
 * 4
 *
 * 1 2
 * 1 3
 * 1 4
 * 2 3
 * 2 4
 * 3 4
 *
 * 1 2 3
 * 1 2 4
 * 1 3 4
 * 2 3 4
 *
 * 1 2 3 4 5
 * 1 2 3
 * 1 2 4
 * 1 2 5
 * 2 3 4
 * 2 3 5
 * 2 4 5
 * 3 4 5
 *
 * @author Zeki
 * @date 2020/11/27 16:42
 */
public class Main {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tempList = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if(k == 0){
            return res;
        }
        dfs(1,n,k);
        return res;
    }

    private void dfs(int i,int n,int k){
        if(tempList.size() == k){
            res.add(new ArrayList<>(tempList));
            return;
        }
        for (int j = i; j <= n; j++) {
            tempList.add(j);
            dfs(j + 1, n, k);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        List<List<Integer>> combine = main.combine(4, 1);
        System.out.println(combine);
    }
}
