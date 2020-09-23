package com.zeki.letcode.questiontop50.question43;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 *
 * 1.num1 和 num2 的长度小于110。
 * 2.num1 和 num2 只包含数字 0-9。
 * 3.num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 4.不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * @author Zeki
 * @date 2020/9/23 13:58
 */
public class Main {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        String ans = "";
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - 48;
            StringBuilder sb = new StringBuilder();
            for (int j = num1.length() - 1; j > i; j--) {
                sb.append(0);
            }
            int carry = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - 48;
                int m = n1 * n2 + carry;
                sb.append(m % 10);
                carry = m / 10;
            }
            if(carry != 0){
                sb.append(carry % 10);
            }
            ans = addStrings(ans,sb.reverse().toString());
        }
        return ans;
    }

    public String multiply2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String ans = "0";
        int m = num1.length(), n = num2.length();
        for (int i = n - 1; i >= 0; i--) {
            StringBuffer curr = new StringBuffer();
            int add = 0;
            for (int j = n - 1; j > i; j--) {
                curr.append(0);
            }
            int y = num2.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                int product = x * y + add;
                curr.append(product % 10);
                add = product / 10;
            }
            if (add != 0) {
                curr.append(add % 10);
            }
            ans = addStrings(ans, curr.reverse().toString());
        }
        return ans;
    }

    /**
     * 两个正数字符串相加的和
     * @param num1 字符串1
     * @param num2 字符串2
     * @return
     */
    public String addStrings(String num1, String num2){
        StringBuilder sb = new StringBuilder();
        if(num1.length() < num2.length()){
            int lenDiff = num2.length() - num1.length();
            for (int i = 1; i <= lenDiff; i++) {
                sb.append('0');
            }
            num1 = sb.append(num1).toString();
        }
        if(num1.length() > num2.length()){
            int lenDiff = num1.length() - num2.length();
            for (int i = 1; i <= lenDiff; i++) {
                sb.append('0');
            }
            num2 = sb.append(num2).toString();
        }
        int carry = 0;
        sb = new StringBuilder();
        for (int i = num1.length() - 1; i >= 0; i--) {
            int tempSum = carry + (num1.charAt(i) - 48) + (num2.charAt(i) - 48);
            if(tempSum >= 10){
                carry = 1;
                sb.append(tempSum - 10);
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
        System.out.println(main.multiply("123", "456"));
        System.out.println(main.addStrings("0", "0"));
    }
}
