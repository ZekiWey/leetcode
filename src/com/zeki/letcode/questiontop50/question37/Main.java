package com.zeki.letcode.questiontop50.question37;

/**
 * 编写一个程序，通过填充空格来解决数独问题。
 *
 * 一个数独的解法需遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 * @author Zeki
 * @date 2020/9/19 10:09
 */
public class Main {

    private final char[] chars = new char[]{'1','2','3','4','5','6','7','8','9'};

    /**
     * 回溯
     * @param board
     */
    public void solveSudoku(char[][] board) {
        backTracking(board,0,0);
    }

    public void backTracking(char[][] board,int row,int col){
        for (int i = row;i < 9;i++){
            for (int j = col; j < 9; j++) {
                if(board[i][j] != '.'){
                    //如果有数字了就直接跳下一个格子
                    continue;
                }
                int n = 0;
                for (; n < 9; n++) {
                    if(check(board,i,j,chars[n])){
                        //选择这个字符
                        board[i][j] = chars[n];
                        //找下一个字符
                        int nr = i,nc = j + 1;
                        if(j == 8){
                            nr = nr + 1;
                            nc = 0;
                        }
                        backTracking(board,nr,nc);
                        //回退选择
                        board[i][j] = '.';
                    }
                }
                if(n >= 9){
                    return;
                }
            }
        }
        System.out.println("=====");
        for (int i = 0; i < board.length; i++) {
            for (int k = 0; k < board[i].length; k++) {
                System.out.printf(" %c ",board[i][k]);
            }
            System.out.println();
        }

    }

    public boolean check(char[][] board,int row,int col,char ans){
        //检查行
        for (int i = 0; i < 9; i++) {
            if(board[row][i] == ans){
                return false;
            }
        }
        //检查列
        for (int i = 0; i < 9; i++) {
            if(board[i][col] == ans){
                return false;
            }
        }
        //检查9宫格
        int c = col / 3 * 3;
        int r = row / 3 * 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c;j < c + 3;j++){
                if(board[i][j] == ans){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
        Main main = new Main();
        /*for (int i = 0; i < board.length; i++) {
            for (int k = 0; k < board[i].length; k++) {
                System.out.printf(" %c ",board[i][k]);
            }
            System.out.println();
        }*/
        main.solveSudoku(board);
        System.out.println("---------------");
        System.out.println("---------------");
        System.out.println("---------------");

        for (int i = 0; i < board.length; i++) {
            for (int k = 0; k < board[i].length; k++) {
                System.out.printf(" %c ",board[i][k]);
            }
            System.out.println();
        }
    }
}
