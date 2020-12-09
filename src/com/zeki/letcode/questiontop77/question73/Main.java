package com.zeki.letcode.questiontop77.question73;

import java.util.Arrays;

/**
 * @author Zeki
 * @date 2020/10/27 19:24
 */
public class Main {

    /**
     * 空间复杂度 m + n
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if(m <= 0){
            return;
        }
        int n = matrix[0].length;
        if(n <= 0){
            return;
        }
        int mm[] = new int[m],nn[] = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 0){
                    mm[i] = 1;
                    nn[j] = 1;
                }
            }
        }
        for (int i = 0; i < mm.length; i++) {
            if(mm[i] == 1){
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < nn.length; i++) {
            if(nn[i] == 1){
                for (int j = 0; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }

    /**
     * 空间复杂度 常数级
     * @param matrix
     */
    public void setZeroes1(int[][] matrix) {
        int m = matrix.length;
        if(m <= 0){
            return;
        }
        int n = matrix[0].length;
        if(n <= 0){
            return;
        }

    }

    public static void main(String[] args) {
        Main main = new Main();
        int[][] matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        main.setZeroes(matrix);

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
