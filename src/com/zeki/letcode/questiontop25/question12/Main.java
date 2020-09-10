package com.zeki.letcode.questiontop25.question12;

public class Main {
    public static void main(String[] args) {
        System.out.println(toRoman2(10));
    }
    private static String toRoman(int num){
        String result = "";
        //个位计算
        if(num > 0){
            result = calc1("I","V","X",num % 10) + result;
            num /= 10;
        }
        //十位计算
        if(num > 0){
            result = calc1("X","L","C",num % 10) + result;
            num /= 10;
        }
        //百位计算
        if(num > 0){
            result = calc1("C","D","M",num % 10) + result;
            num /= 10;
        }
        //千位计算
        if(num > 0){
            result = calc1("M","X","Y",num % 10) + result;
        }
        return result;
    }

    private static String calc1(String yi,String wu,String shi,int num){
       String[] strings = new String[]{
               "",yi,yi+yi,yi+yi+yi,yi+wu,wu,wu+yi,wu+yi+yi,wu+yi+yi+yi,yi+shi
       };
       return strings[num];
    }


    private static String calc2(int x,int num){
        String[][] strings = new String[][]{
            {"","I","II","III","IV","V","VI","VII","VIII","IX"},
            {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
            {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
            {"","M","MM","MMM"}
        };
        return strings[x][num];
    }
    private static String toRoman2(int num){
        String result = "";
        //个位计算
        int x  = 0;
        while(num != 0){
            result = calc2(x++,num % 10) + result;
            num /= 10;
        }
        return result;
    }

}
