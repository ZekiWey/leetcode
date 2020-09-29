package com.zeki.letcode.questiontop50.question48;

/**
 *给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 说明：
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 *给定 matrix =
 * [
 *   [1,2,3],   1->3,2->6,3->9     11 12 13    7,8,9    7,4,1      1,2  2,1    1,3  3,1
 *   [4,5,6],   4->2,5->5,6->8     21 22 23    4,5,6    8,5,2
 *   [7,8,9]    7->1,8->4,9->7     31 32 33    1,2,3    9,6,3
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],         00 03 33 30
 *   [ 2, 4, 8,10],         01 13 32 20
 *   [13, 3, 6, 7],         02 23 31 10
 *   [15,14,12,16]          11 12 21 22
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 *
 * @author Zeki
 * @date 2020/9/25 14:39
 */
public class Main {

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        //上下翻转
        for (int i = 0; i < n / 2; i++) {
            int mirrorI = n - i - 1;
            if(i == mirrorI){
                continue;
            }
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[mirrorI][j];
                matrix[mirrorI][j] = temp;
            }
        }
        //镜像翻转
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if(i == j){
                    continue;
                }
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    /**
     * 00 03 33 30
     * 01 13 32 20
     * 02 23 31 10
     * 11 12 21 22
     * @param matrix
     */
    public void rotate2(int[][] matrix) {
        int temp[] = new int[4];
        int n = matrix.length;

        for (int i = 0; i < n / 2; i++) {
            for(int j = 0;j < n / 2;j++){
                System.out.println(i);
                System.out.println(j);
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix1 = new int[][]{{5, 1, 9,11},{2, 4, 8,10},{13, 3, 6, 7},{15,14,12,16}};
        Main main = new Main();
        main.rotate2(matrix1);

        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            System.out.println();
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf(" %d ",matrix[i][j]);
            }
        }
    }
}
