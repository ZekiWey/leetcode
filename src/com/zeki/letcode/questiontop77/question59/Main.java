package com.zeki.letcode.questiontop77.question59;

import java.util.Arrays;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵
 *
 * 示例:
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * @author Zeki
 * @date 2020/10/10 17:51
 */
public class Main {

    public int[][] generateMatrix(int n) {
        int s[][] = new int[n][n];
        int minRow = 0,maxRow = n - 1;
        int minCol = 0,maxCol = n - 1;
        int row = 0,col = 0;

        int x = 1;
        while (minRow <= maxRow && minCol <= maxCol){
            row = minRow;
            col = minCol;
            while (col <= maxCol){
                s[row][col] = x;
                x++;
                col++;
            }
            col = maxCol;
            row = minRow + 1;
            while (row <= maxRow){
                s[row][col] = x;
                x++;
                row++;
            }
            if (minCol < maxCol && minRow < maxRow) {
                row = maxRow;
                col = maxCol - 1;
                while (col >= minCol){
                    s[row][col] = x;
                    x++;
                    col--;
                }
                col = minCol;
                row = maxRow -1;
                while (row >= minRow + 1){
                    s[row][col] = x;
                    x++;
                    row--;
                }
            }
            minCol++;minRow++;maxCol--;maxRow--;

        }
        return s;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[][] ints = main.generateMatrix(0);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(Arrays.toString(ints[i]));
        }
    }
}
