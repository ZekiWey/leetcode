package com.zeki.letcode.questiontop100.question79;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *
 * @author Zeki
 * @date 2020/11/28 11:02
 */
public class Main {

    private boolean stop = false;

    private boolean[][] use;

    public boolean exist(char[][] board, String word) {
        if(board.length == 0 || board[0].length == 0 ||
                word == null || word.length() == 0){
            return false;
        }
        int row = board.length;
        int col = board[0].length;

        use = new boolean[row][col];

        for (int r = 0; r < row && !stop; r++) {
            for (int c = 0; c < col && !stop ; c++) {
                if(word.charAt(0) == board[r][c]){
                    //System.out.println(r + ":" + c);
                    use[r][c] = true;
                    dfs(board,row,col,r,c,word,1);
                    use[r][c] = false;
                }
            }
        }
        return stop;
    }



    private void dfs(char[][] board,int row,int col,int r,int c,String word,int n){
        if(n == word.length()){
            stop = true;
            return;
        }
        //向右找
        if(!stop && c + 1 < col){
            if(!use[r][c + 1] &&word.charAt(n) == board[r][c + 1]){
                use[r][c + 1] = true;
                dfs(board, row, col, r, c + 1, word, n + 1);
                use[r][c + 1] = false;
            }
        }
        //向下找
        if(!stop && r + 1 < row){
            if(!use[r + 1][c] && word.charAt(n) == board[r + 1][c]){
                use[r + 1][c] = true;
                dfs(board, row, col, r + 1, c, word, n + 1);
                use[r + 1][c] = false;
            }
        }
        //向左
        if(!stop && c - 1 >= 0){
            if(!use[r][c-1] && word.charAt(n) == board[r][c - 1]){
                use[r][c - 1] = true;
                dfs(board, row, col, r, c - 1, word, n + 1);
                use[r][c - 1] = false;
            }
        }

        //向上
        if(!stop && r - 1 >= 0){
            if(!use[r - 1][c] && word.charAt(n) == board[r - 1][c]){
                use[r - 1][c] = true;
                dfs(board, row, col, r - 1, c, word, n + 1);
                use[r - 1][c] = false;
            }
        }
    }


    public static void main(String[] args) {
        Main main = new Main();
        char[][] b = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(main.exist(b, "SEE"));
        char[][] b1 = new char[][]{{'A','B'},{'C','D'}};
        System.out.println(main.exist(b, "ACDB"));
    }
}
