package com.zeki.letcode.questiontop25.question5;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {


    public static void main(String[] args) {
        String s = "ccc";
        long beginTime = System.currentTimeMillis();
        System.out.println(findSubStr(s));
        System.out.println(System.currentTimeMillis() - beginTime);
    }

    /**
     * 查找最大回文子串
     * @param s 输入的字符串
     * @return 最大回文子串
     */
    private static String findSubStr(String s) {
        int len = s.length();
        Integer maxLen = 0;
        String maxLenStr = "";
        String subStr;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1;j <= len;j++){
                if(j -i <= maxLen){
                    continue;
                }
                subStr = s.substring(i,j);
                if(check(subStr)){
                    if(j - i > maxLen){
                        maxLenStr = subStr;
                        maxLen = j - i;
                    }
                }
            }
        }
        return maxLenStr;
    }

    /**
     * 判断字符串是否是回文字符串
     * @param str 字符串
     * @return boolean
     */
    private static boolean check(String str){
        int len = str.length();
        if(len == 1){
            return true;
        }
        if(str.charAt(0) != str.charAt(len-1)){
            return false;
        }
        int j = len / 2;
        for (int i = 1; i <= j; i++) {
            if(str.charAt(i-1) != str.charAt(len-i)){
                return false;
            }
        }
        return true;
    }
}
