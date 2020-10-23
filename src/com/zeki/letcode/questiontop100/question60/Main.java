package com.zeki.letcode.questiontop100.question60;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 *
 * 示例:
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 输入: n = 4, k = 9
 * 输出: "2314"
 *
 * @author Zeki
 * @date 2020/10/10 17:59
 */
public class Main {

    public String getPermutation(int n, int k) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {

        }
        return list.get(k);
    }

    public void backAll(int begin,int n,List<String> res){
        for (int i = begin; i < n; i++) {
            for (int i1 = 0; i1 < n; i1++) {

            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.getPermutation(3, 3));
    }
}
