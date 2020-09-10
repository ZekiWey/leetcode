package com.zeki.letcode.lianxi.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * N皇后问题 回溯算法解决
 * @author Zeki
 * @date 2020/9/7 17:54
 */
public class NQueen {

    public List<List<Integer>> nQueen(int n){

        List<List<Integer>> res = new ArrayList<>();
        backTracking(new ArrayList<Integer>(),res,0,n);

        return res;
    }

    private void backTracking(List<Integer> list,List<List<Integer>> res,int row,int n){
        if(list.size() == n){
            res.add(new ArrayList<>(list));
            return;
        }else {
            for (int i = 0; i < n; i++) {
                if(!checkQ(i,row,list)){
                    continue;
                }
                list.add(i);
                backTracking(list,res,row + 1,n);
                list.remove(row);
            }
        }
    }

    private boolean checkQ(int num,int row,List<Integer> list){
        if(list.contains(num)){
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if(Math.abs(row - i) == Math.abs(num - list.get(i))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 8;
        List<List<Integer>> lists = new NQueen().nQueen(n);
        System.out.println(lists);
        System.out.println(lists.size());

        System.out.println();
        for (List<Integer> list : lists) {
            for (int i = 0; i < n; i++) {
                int num = list.get(i);
                for (int i1 = 0; i1 < n; i1++) {
                    if(num == i1){
                        System.out.printf(" %s ","Q");
                    }else {
                        System.out.printf(" %s ","1");
                    }

                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
