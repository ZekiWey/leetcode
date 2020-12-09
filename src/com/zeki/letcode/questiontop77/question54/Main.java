package com.zeki.letcode.questiontop77.question54;

import java.util.ArrayList;
import java.util.List;

/**
 *给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * @author Zeki
 * @date 2020/9/29 15:15
 */
public class Main {

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if(m <= 0){
            return new ArrayList<>(1);
        }
        int n = matrix[0].length;
        if(n <= 0){
            return new ArrayList<>(1);
        }

        List<Integer> list = new ArrayList<>(n * m);

        int minRow = 0,maxRow = m - 1;
        int minCol = 0,maxCol = n - 1;
        int row = 0,col = 0;

        while (minRow <= maxRow && minCol <= maxCol){
            row = minRow;
            col = minCol;
            while (col <= maxCol){
                list.add(matrix[row][col]);
                col++;
            }
            col = maxCol;
            row = minRow + 1;
            while (row <= maxRow){
                list.add(matrix[row][col]);
                row++;
            }
            if (minCol < maxCol && minRow < maxRow) {
                row = maxRow;
                col = maxCol - 1;
                while (col >= minCol){
                    list.add(matrix[row][col]);
                    col--;
                }
                col = minCol;
                row = maxRow -1;
                while (row >= minRow + 1){
                    list.add(matrix[row][col]);
                    row--;
                }
            }
            minCol++;minRow++;maxCol--;maxRow--;

        }

        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2},{3,4}};

        Main main = new Main();
        System.out.println(main.spiralOrder(matrix));
    }

    /**
     *  i = 0;i = 0;j < length - 0
     *
     *  i = i + 1;i < length - 0;
     *
     *  0++;
     *
     *  j = j - 1;j >= 0;
     *  i = i + 1;i < length -1;
     *
     *  j = j - 1;j >= 1;
     *
     *  ① 00 01 02 ② 12 22 ③ 21 20  ④10  ⑤11
     *   0  1  2
     *   3  4  5
     *   6  7  8
     *
     *   n / 3;0 0 0 1 1 1 2 2 2
     *   n % 3;0 1 2 0 1 2 0 1 2
     *
     *
     *   0 = 00;1 = 01;2 = 02;
     *   3 = 12;4 = 22;5 = 21;6 = 20;7 = 10;8 = 11;
     *
     *   0 = 0;1 = 1;2 = 2;
     *   3 = 5;4 = 8;5 = 7;6 = 6;7 = 3;8 = 4;
     *
     *
     *   00 01 02 03 13 23 22 21 20 10 11 12
     *   1, 2, 3, 4
     *   5, 6, 7, 8
     *   9,10,11,12
     *
     *   00 01 02 12 22 32 31 30 20 10 11 22
     *   1 2 3
     *   4 5 6
     *   7 8 9
     *  10 11 12
     *
     *  2 5
     *  8 4
     *  0 -1
     */
}
