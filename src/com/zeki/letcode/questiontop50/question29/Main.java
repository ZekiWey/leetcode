package com.zeki.letcode.questiontop50.question29;

/**
 * @author Zeki
 * @date 2020/9/9 11:07
 */
public class Main {
    public int divide(int dividend, int divisor) {

        if(Math.abs(dividend) < 0 && divisor == -1){
            dividend = -2147483647;
        }

        int temp = divisor;

        temp = temp << 1;
        int sum = 0;
        while (temp < dividend){
            sum++;
            temp = temp << 1;
        }
        System.out.println(sum);

        System.out.println(temp - dividend);

        int res = 0;
        for (int i = 0; i < sum; i++) {
            res = res + divisor;
        }

        System.out.println(res);

        return -1;

    }


    public static void main(String[] args) {
        //System.out.println(new Main().divide(-2147483648, -1));
        System.out.println(new Main().divide(15, 3));
        //System.out.println(new Main().divide(1, 2));
        //System.out.println(new Main().divide(-2147483648, -1));
        //System.out.println(2 << 1);
    }
}
