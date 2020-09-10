package com.zeki.letcode.questiontop25.question6;

public class Main {
    public static void main(String[] args) {
        System.out.println(sortStr("ABC", 1));
    }


    public static String sortStr(String s,int numRows){
        if(numRows == 1){
            return s;
        }
        int col = s.length();
        char[][] chars = new char[numRows][col];
        //向上true 向下false
        boolean up = false;
        //初始化当前的行
        int currentRow = 0;
        //初始化当前列
        int currentCol = 0;
        //开始循环字符串
        for (int i = 0; i < col; i++) {
            if(up){
                //如果当前是向上
                //输出列每次加2
                currentCol = currentCol + 2;
                //放入字符
                chars[currentRow][currentCol] = s.charAt(i);
                //指向下一行
                if(currentRow == 0){
                    //如果当前行是第一行
                    currentRow = 1;
                    //设置当前标志为向下
                    up = false;
                }else {
                    //上移一行
                    currentRow = currentRow - 1;
                }
            }else {
                //如果是向下 数据列不变
                chars[currentRow][currentCol] = s.charAt(i);
                if(currentRow == numRows - 1){
                    //如果是最后一行
                    //上移一行
                    currentRow = currentRow - 1;
                    //设置当前标志为向上
                    up = true;
                }else {
                    //下移一行
                    currentRow = currentRow + 1;
                }
            }
        }
        //输出结果
        char[] target = new char[col];
        int p = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < col; j++) {
                if(chars[i][j] != '\0'){
                    target[p++] = chars[i][j];
                }
            }
        }
        return String.valueOf(target);
    }
    /**
     * 1  5 8
     * 2 4 6 9
     * 3  7
     */
}
