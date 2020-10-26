package com.zeki.letcode.questiontop50.question36;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zeki
 * @date 2020/9/18 17:23
 */
public class Main {
    public boolean isValidSudoku(char[][] board) {
        Map<String,Integer> rowMap = new HashMap<>(81);
        Map<String,Integer> colMap = new HashMap<>(81);
        Map<String,Integer> squareMap = new HashMap<>(81);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.'){
                    //行
                    Integer integer = rowMap.get("" + i + board[i][j]);
                    if(integer != null){
                        return false;
                    }
                    rowMap.put("" + i + board[i][j], 1);
                    //方形
                    integer = squareMap.get("" + i/3 + "" + j/3 + board[i][j]);
                    if(integer != null){
                        return false;
                    }
                    squareMap.put("" + i/3 + "" + j/3 + board[i][j], 1);
                }

                if(board[i][j] != '.'){
                    //列
                    Integer integer = colMap.get("" + j + board[i][j]);
                    if(integer != null){
                        return false;
                    }
                    colMap.put("" + j + board[i][j], 1);
                }


            }
        }
        return true;
    }

    public boolean isValidSudoku1(char[][] board) {
        int[][] col = new int[9][10];
        int[][] row = new int[9][10];
        int[][] square = new int[9][10];


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.'){
                    //行
                    if(row[i][board[i][j] - 48] > 0){
                        return false;
                    }
                    row[i][board[i][j] - 48] = 1;

                    if(col[j][board[i][j] - 48] > 0){
                        return false;
                    }
                    col[j][board[i][j] - 48] = 1;

                    //方形
                    int index = (i / 3) * 3 + j / 3;
                    if(square[index][board[i][j] - 48] > 0){
                        return false;
                    }
                    square[index][board[i][j] - 48] = 1;
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

        System.out.println(new Main().isValidSudoku1(board));
    }
}
