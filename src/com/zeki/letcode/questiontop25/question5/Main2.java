package com.zeki.letcode.questiontop25.question5;

public class Main2 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("sssssssssss"));
    }

    public static String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return s;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int left = 0;
        int right = 0;
        for (int i = len - 2; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < len; j++) {
                //小于3是因为aba一定是回文
                dp[i][j] = s.charAt(i) == s.charAt(j) &&( j - i < 3 || dp[i+1][j-1]);
                if(dp[i][j] && right - left < j-i){
                    left=i;
                    right=j;
                }
            }
        }
        return s.substring(left,right+1);
    }
}
