package com.zeki.letcode.questiontop50.question50;

/**
 * @author Zeki
 * @date 2020/9/27 14:14
 */
public class Main {

    public double myPow(double x, int n) {
        if(n == 0){
            return 1.0;
        }
        long absN = n;
        absN = absN < 0 ? -absN : absN;
        double res = 1;
        for (; absN > 0;) {
            if(absN % 2 == 1){
                res *= x;
            }
            x = x * x;
            absN = absN/2;
        }
        return n >= 0 ? res : (1.0 / res);
    }

    /**
     * 官方递归解法
     * x的N次方 N>=0
     * @param x
     * @param N
     * @return
     */
    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    //   2 2 2 2 2 2 2 2 2 2
    //    4   4   4   4   4  1
    //      16      16     4  1
    //          256          4
    //    4 16 256
    // 10 5 2 1 0

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.myPow(2, 1));
        System.out.println(main.myPow(2, 2));
        System.out.println(main.myPow(2, 3));
        System.out.println(main.myPow(2, 4));
        System.out.println(main.myPow(2, -2147483648));

        //System.out.println(main.calc(2, 100, 1));
    }
}
