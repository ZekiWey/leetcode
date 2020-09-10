package com.zeki.letcode.questiontop25.question20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Zeki
 * @date 2020/9/7 14:50
 */
public class Main {


    public boolean isValid(String s) {
        return isValid2(s);
    }

    private static Map<Character,Character> map = new HashMap<>(3);
    static {
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
    }

    /**
     * 使用栈
     * @param s 输入
     * @return
     */
    private boolean isValid2(String s){
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            Character character = map.get(c);
            if(character == null){
                stack.push(c);
            }else {
                if(stack.isEmpty() || !stack.pop().equals(character)){
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }

    /**
     * @deprecated 无效
     * 暴力解法
     * @param s 输入
     * @return
     */
    private boolean isValid1(String s){
        int sl = 0,sr = 0;
        int ml = 0,mr = 0;
        int ll = 0,lr = 0;
        for (char c : s.toCharArray()) {
            if(c == '('){
                sl++;
            }
            if(c == ')'){
                sr++;
            }
            if(c == '['){
                ml++;
            }
            if(c == ']'){
                mr++;
            }
            if(c == '{'){
                ll++;
            }
            if(c == '}'){
                lr++;
            }
        }
        return sr - sl == 0 && mr - ml == 0 && lr - ll == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Main().isValid("(){}[]"));
    }
}
