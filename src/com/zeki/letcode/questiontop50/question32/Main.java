package com.zeki.letcode.questiontop50.question32;

import java.util.Stack;

/**
 * 32.给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * @author Zeki
 * @date 2020/9/14 11:43
 */
public class Main {
    public int longestValidParentheses(String s) {
        Stack<Integer> ls = new Stack<>();

        int max = 0,temp = 0;
        for (int i = 0; i < s.length(); i++) {
           char c = s.charAt(i);
           if(c == '('){
               ls.push(temp);
           }
           if(c == ')'){
               if(ls.size() <= 0){
                   //说明没有与右括号匹配的左括号了,记录当前长度并重置计数
                   if(temp > max){
                       max = temp;
                   }
                   temp = 0;
               }else {
                   //从栈顶弹出一个左括号并将当前长度+2
                   ls.pop();
                   temp += 2;
               }
           }
        }
        if(ls.size() > 0){
            //遍历完成后如果栈内还有元素
            if(temp < max){
                return max;
            }
            //循环找出中断位置重新计算长度
            while (ls.size() > 0 && temp > max){
                //获取中断位置入栈前的长度
                Integer pop = ls.pop();
                if(temp - pop > max){
                    max = temp - pop;
                }
                temp = pop;
            }
            if(temp > max){
                return temp;
            }
        }else {
            if(temp > max){
                return temp;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s1 = ")()())";
        String s2 = "((())";
        String s3 = "()(()";
        String s4 = "(()()";
        String s5 = "()()(()";
        String s6 = "()(()(((";
        String s7 = "(()(((()";
        String s8 = ")(((((()())()()))()(()))(";
        String s9 = "((((()())()()))()(()))";
        System.out.println(new Main().longestValidParentheses(s9));
    }
}
