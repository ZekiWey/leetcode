package com.zeki.letcode.questiontop25.question17;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zeki
 * @date 2020/9/7 11:15
 */
public class Main {

    private StringBuilder sb = new StringBuilder();

    public static String[] keyboard = new String[8];

    static {
        keyboard[0] = "abc";
        keyboard[1] = "def";
        keyboard[2] = "ghi";
        keyboard[3] = "jkl";
        keyboard[4] = "mon";
        keyboard[5] = "pqrs";
        keyboard[6] = "tuv";
        keyboard[7] = "wxyz";
    }

    List<String> resList = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) {
            return resList;
        }
        backtrack(digits,0);
        return resList;
    }

    // 回溯函数
    private void backtrack(String digits,int index) {
        if(sb.length() == digits.length()) {
            resList.add(sb.toString());
            return;
        }
        String val = keyboard[digits.charAt(index)-'2'];
        for(char ch:val.toCharArray()) {
            sb.append(ch);
            backtrack(digits,index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Main().letterCombinations("234"));
    }
}
