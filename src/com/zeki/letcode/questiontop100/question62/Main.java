package com.zeki.letcode.questiontop100.question62;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 *
 * 输入: m = 3, n = 2
 * 输出: 3
 * 输入: m = 7, n = 3
 * 输出: 28
 *
 * @author Zeki
 * @date 2020/10/16 15:24
 */
public class Main {

    public int uniquePaths(int m, int n) {
        //往右固定走 m-1步
        //往下固定走 n-1步
        //求 c(m-1,m+n-2)即可
        int a = m - 1;
        int b = m + n - 2;
        long b1 = 1;
        for (int i = 1; i <= a; i++) {
            b1 = b1 * (b - a + i);
            b1 = b1 / i;
        }
        return (int) b1;
    }

    public int uniquePaths2(int m,int n){
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ",dp[i][j]);
            }
            System.out.println();
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.uniquePaths2(4, 4));
    }
}
