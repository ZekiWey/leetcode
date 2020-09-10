package com.zeki.letcode.lianxi.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 四皇后问题
 * @author Zeki
 * @date 2020/9/7 16:44
 */
public class FourQueen {

    public List<List<Integer>> fourQueen(){

        List<List<Integer>> res = new ArrayList<>();
        backTracking(new ArrayList<Integer>(),res,0);

        return res;
    }

    private void backTracking(List<Integer> list,List<List<Integer>> res,int row){
        if(list.size() == 4){
            res.add(new ArrayList<>(list));
            return;
        }else {
            for (int i = 0; i < 4; i++) {
                if(list.size() > 0 && list.contains(i)){
                    continue;
                }
                if(list.size() > 0 && i ==  list.get(row-1) + 1){
                    continue;
                }
                if(list.size() > 0 && i ==  list.get(row-1) - 1){
                    continue;
                }
                list.add(i);
                backTracking(list,res,row + 1);
                list.remove(row);
            }
        }
    }




    public static void main(String[] args) {
        List<List<Integer>> lists = new FourQueen().fourQueen();
        for (List<Integer> list : lists) {
            for (int i = 0; i < 4; i++) {
                int num = list.get(i);
                for (int i1 = 0; i1 < 4; i1++) {
                    if(num == i1){
                        System.out.printf(" %d ",1);
                    }else {
                        System.out.printf(" %d ",0);
                    }

                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
