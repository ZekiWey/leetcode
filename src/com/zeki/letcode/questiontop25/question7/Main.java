package com.zeki.letcode.questiontop25.question7;

public class Main {

    public static void main(String[] args) {
        System.out.println(reverserInt1(-2147483648));
    }

    private static  Integer reverserInt(Integer x){
        if(x == 0){
            return 0;
        }
        if(x <= Integer.MIN_VALUE || x >= Integer.MAX_VALUE){
            return 0;
        }
        long num = Math.abs(x);
        System.out.println(num);
        StringBuilder sb = new StringBuilder();
        while (num != 0){
            sb.append(num % 10);
            num = num / 10;
        }
        System.out.println(sb);
        long target = (x < 0 ? -1 : 1) * Long.parseLong(sb.toString());
        if(target > Integer.MAX_VALUE || target < Integer.MIN_VALUE){
            return 0;
        }
        return (int)target;
    }

    private static  Integer reverserInt1(Integer x){
        int target = 0;
        while (x != 0){
            int mod = x % 10;
            x = x / 10;
            if(target > Integer.MAX_VALUE / 10 || (target == Integer.MAX_VALUE / 10 && mod > 7)){
                return 0;
            }
            if(target < Integer.MIN_VALUE / 10 || (target == Integer.MIN_VALUE / 10 && mod < -8)){
                return 0;
            }
            target = target * 10 + mod;
        }
        return target;
    }


}
