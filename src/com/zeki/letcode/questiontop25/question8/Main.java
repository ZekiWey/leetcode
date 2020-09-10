package com.zeki.letcode.questiontop25.question8;

public class Main {
    public static void main(String[] args) {
        System.out.println(praseInt("  -42"));
    }
    private static Integer praseInt(String str){
        str = str.trim();
        int target = 0;
        int fuhao = 1;
        boolean fuhaoFlag = false;
        boolean numFlag = false;

        int len = str.length();
        for (int i = 0; i < len; i++) {
            int si = str.charAt(i);
            if(si >= 48 && si <= 57){
                si = si - 48;
                if(fuhao < 0){
                    if(target > Integer.MAX_VALUE / 10 + 1 || (target + 1  == Integer.MAX_VALUE / 10 + 1 && si > 8)){
                        return Integer.MIN_VALUE;
                    }
                }else {
                    if(target > Integer.MAX_VALUE / 10 || (target == Integer.MAX_VALUE / 10 && si > 7)){
                        return Integer.MAX_VALUE;
                    }
                }
                target = target * 10 + si;
                numFlag = true;
            }else{
                if(numFlag || fuhaoFlag){
                    break;
                }
                if((si == 45 || si == 43)){
                    fuhao = si == 45 ? -1 : 1;
                    fuhaoFlag = true;
                    numFlag = true;
                }else {
                    break;
                }
            }
        }
        return fuhao * target;
    }
}
