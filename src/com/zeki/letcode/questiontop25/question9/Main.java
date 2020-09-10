package com.zeki.letcode.questiontop25.question9;

public class Main {
    public static void main(String[] args) {
        System.out.println(check(12));
    }

    /**
     * 检查一个是否是回文
     * @param x 输入整数
     * @return
     */
    private static boolean check(int x){
        if(x < 0){
            return false;
        }
        if(x < 10){
            return true;
        }
        if(x == reverserInt(x)){
            return true;
        }
        return false;
    }

    private static Integer reverserInt(Integer x){
        int target = 0;
        while (x != 0){
            int mod = x % 10;
            x = x / 10;
            if(target > Integer.MAX_VALUE / 10 || (target == Integer.MAX_VALUE / 10 && mod > 7)){
                return 0;
            }
            target = target * 10 + mod;
        }
        return target;
    }
}
