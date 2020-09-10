package com.zeki.letcode.questiontop25.question14;

public class Main {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix2(new String[]{"flower", "flow", "flight"}));
    }

    private static String longestCommonPrefix(String[] strs) {
        if(strs.length <= 0){
            return "";
        }
        int minLength = strs[0].length();
        for (String str : strs) {
            int tempLen = str.length();
            if(tempLen < minLength){
                minLength = tempLen;
            }
        }
        if(minLength == 0){
            return "";
        }
        for (int i = minLength; i > 0; i--) {
            String tempStr = strs[0].substring(0,i);
            boolean flag = true;
            for (String str : strs) {
                if(!str.substring(0,i).equals(tempStr)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return tempStr;
            }
        }
        return "";
    }

    private static String longestCommonPrefix2(String[] strs) {
        if(strs.length <= 0){
            return "";
        }
        int minLength = strs[0].length();
        for (String str : strs) {
            int tempLen = str.length();
            if(tempLen < minLength){
                minLength = tempLen;
            }
        }
        if(minLength == 0){
            return "";
        }
        String publicSubStr = "";
        for (int i = 1; i <= minLength; i++) {
            String tempStr = strs[0].substring(0,i);
            boolean flag = true;
            for (String str : strs) {
                if(!str.substring(0,i).equals(tempStr)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                publicSubStr = tempStr;
            }else {
                break;
            }
        }
        return publicSubStr;
    }
}
