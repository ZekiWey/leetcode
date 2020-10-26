package com.zeki.letcode.questiontop100.question66;

import java.util.Arrays;

/**
 * @author Zeki
 * @date 2020/10/26 11:37
 */
public class Main {

    public int[] plusOne(int[] digits) {
        int u = 1;
        int i = digits.length - 1;
        while (u == 1 && i >= 0){
            digits[i] = (digits[i] + u) % 10;
            if(digits[i] == 0){
                u = 1;
            }else {
                u = 0;
            }
            i--;
        }
        if(u == 1){
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = u;
            for (int j = 0; j < digits.length; j++) {
                newDigits[j + 1] = digits[j];
            }
            return newDigits;
        }
        return digits;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] digits = new int[]{9,9,9};
        int[] ints = main.plusOne(digits);
        System.out.println(Arrays.toString(ints));
    }
}
