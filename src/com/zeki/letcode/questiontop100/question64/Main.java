package com.zeki.letcode.questiontop100.question64;

/**
 * @author Zeki
 * @date 2020/10/23 16:32
 */
public class Main {
    public int minPathSum(int[][] grid) {
        if(grid.length <= 0){
            return 0;
        }
        if(grid[0].length <= 0){
            return 0;
        }
        int m = grid.length,n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + (dp[i - 1][j] > dp[i][j-1] ? dp[i][j-1] : dp[i - 1][j]);
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
        int[][] mn = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        main.minPathSum(mn);
    }
}
