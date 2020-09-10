package com.zeki.letcode.questiontop25.question22;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zeki
 * @date 2020/9/7 15:55
 */
public class Main {

    StringBuilder sb = new StringBuilder();

    List<String> resList = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if(n <= 0) {
            return resList;
        }
        backtrack(n ,0,0);
        return resList;
    }

    public void backtrack(int n,int open,int close){
        if(sb.length() == n * 2){
            resList.add(sb.toString());
            return;
        }
        if(open < n){
            sb.append('(');
            backtrack(n,open + 1,close);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(close < open){
            sb.append(')');
            backtrack(n,open,close + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Main().generateParenthesis(3));
    }

}
