package com.zeki.letcode.questiontop77.question74;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
 * 输出：true
 * @author Zeki
 * @date 2020/10/27 20:50
 */
public class Main {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m <= 0){
            return false;
        }
        int n = matrix[0].length;
        if(n <= 0){
            return false;
        }
        int size = m * n;

        int l = 1;int r = size;

        while (l <= r){
            int mid = (l + r) / 2;
            int num = get(matrix, m, n, mid);
            if(num == target)
                return true;
            else if (num < target)
                l = mid + 1; // 注意
            else if (num > target)
                r = mid - 1; // 注意
        }


        return false;
    }

    public int get(int[][] matrix,int m,int n,int index){
        int i,j;
        if(index % n == 0){
            i = index / n - 1;
            j = n - 1;
        }else {
            i = index / n;
            j = index % n - 1;
        }
        return matrix[i][j];
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        System.out.println(main.searchMatrix(matrix, 2));
    }
}
