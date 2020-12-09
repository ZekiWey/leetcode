package com.zeki.letcode.questiontop77.question51;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zeki
 * @date 2020/9/28 10:06
 */
public class Main {
    public List<List<String>> solveNQueens(int n) {
        List<List<Integer>> res = new ArrayList<>();
        backTracking(new ArrayList<Integer>(),res,0,n);

        List<List<String>> strRes = new ArrayList<>();
        for (List<Integer> re : res) {
            List<String> list = new ArrayList<>();
            for (Integer integer : re) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    if(i == integer){
                        sb.append('Q');
                    }else {
                        sb.append('.');
                    }
                }
                list.add(sb.toString());
            }
            strRes.add(list);
        }
        return strRes;
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
        Main main = new Main();
        List<List<String>> lists = main.solveNQueens(0);
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println();
        }
    }
}
