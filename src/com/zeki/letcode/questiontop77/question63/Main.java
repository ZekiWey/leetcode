package com.zeki.letcode.questiontop77.question63;

/**
 * @author Zeki
 * @date 2020/10/23 13:58
 */
public class Main {

    public int uniquePathsWithObstacles(int[][] obstacleGrid){
        if(obstacleGrid.length <= 0){
            return 0;
        }
        if(obstacleGrid[0].length <= 0){
            return 0;
        }
        int m = obstacleGrid.length,n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 1; i < n; i++) {
            dp[0][i] = obstacleGrid[0][i] == 0 && dp[0][i - 1] == 1 ? 1 : 0;
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = obstacleGrid[i][0] == 0 && dp[i - 1][0] == 1 ? 1 : 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
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
        int[][] mn = new int[][]{{0,1,0},{0,0,0},{0,0,0}};
        System.out.println(main.uniquePathsWithObstacles(mn));
    }

    /**
     *  0 1 0    1 0 1
     *  0 1 0    1 0 0
     *  0 0 0    1 1 0
     */
}
