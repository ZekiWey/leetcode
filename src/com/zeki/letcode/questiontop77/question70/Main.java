package com.zeki.letcode.questiontop77.question70;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 * @author Zeki
 * @date 2020/10/27 11:04
 */
public class Main {

    /**
     * 1  -   1
     * 2  -   1 + f(1) = 2
     * 3  -   f(1) + f(2) = 3
     * 4  -   f(2) + f(3) = 5
     * 5  -   f(3) + f(4)
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int l = 0,r = 1,t;
        for (int i = 1; i <= n; i++) {
            t = l + r;
            l = r;
            r = t;
        }
        return r;
    }



    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.climbStairs(4));
    }
}
