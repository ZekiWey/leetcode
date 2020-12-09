package com.zeki.letcode.questiontop77.question67;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * @author Zeki
 * @date 2020/10/26 13:56
 */
public class Main {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        if(a.length() < b.length()){
            int lenDiff = b.length() - a.length();
            for (int i = 1; i <= lenDiff; i++) {
                sb.append('0');
            }
            a = sb.append(a).toString();
        }
        if(a.length() > b.length()){
            int lenDiff = a.length() - b.length();
            for (int i = 1; i <= lenDiff; i++) {
                sb.append('0');
            }
            b = sb.append(b).toString();
        }
        int carry = 0;
        sb = new StringBuilder();
        for (int i = a.length() - 1; i >= 0; i--) {
            int tempSum = carry + (a.charAt(i) - 48) + (b.charAt(i) - 48);
            if(tempSum >= 2){
                carry = 1;
                sb.append(tempSum - 2);
            }else {
                sb.append(tempSum);
                carry = 0;
            }
        }
        if(carry == 1){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.addBinary("110", "101"));
    }
}
