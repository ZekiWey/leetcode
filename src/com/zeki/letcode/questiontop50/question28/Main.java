package com.zeki.letcode.questiontop50.question28;

/**
 * @author Zeki
 * @date 2020/9/9 9:17
 */
public class Main {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null){
            return -1;
        }
        if(haystack.length() == 0){
            if(needle.length() == 0){
                return 0;
            }else {
                return -1;
            }
        }
        if(needle.length() == 0){
            return 0;
        }

        char[] p = haystack.toCharArray();
        char[] c = needle.toCharArray();

        for (int i = 0; i <= p.length - c.length;i++) {
            int j = 0;
            boolean flag = true;
            for (; j < c.length; j++) {
                if(p[i + j] != c[j]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return i;
            }
        }
        return -1;
    }

    public int strStr1(String haystack, String needle) {
        if(haystack == null || needle == null){
            return -1;
        }
        if(haystack.length() == 0){
            if(needle.length() == 0){
                return 0;
            }else {
                return -1;
            }
        }
        if(needle.length() == 0){
            return 0;
        }

        char[] p = haystack.toCharArray();
        char[] c = needle.toCharArray();

        for (int i = 0; i <= p.length - c.length;) {
            int j = 0;
            boolean flag = true;
            for (; j < c.length; j++) {
                if(p[i + j] != c[j]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return i;
            }
            //找下一个 c[0] 所在的p的位置
            i++;
            while (i <= p.length - c.length){
                if(p[i] == c[0]){
                    break;
                }
                i++;
            }
        }
        return -1;
    }

    public int strStr2(String haystack, String needle) {
        if(haystack == null || needle == null){
            return -1;
        }
        if(haystack.length() == 0){
            if(needle.length() == 0){
                return 0;
            }else {
                return -1;
            }
        }
        if(needle.length() == 0){
            return 0;
        }

        char[] p = haystack.toCharArray();
        char[] c = needle.toCharArray();

        int pi = 0;
        while (pi <= p.length - c.length){
            boolean flag = true;
            for (int ci = 0; ci < c.length; ci++) {
                if(p[pi + ci] != c[ci]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return pi;
            }
            if(pi + c.length >= p.length){
                return -1;
            }
            int in = -1;
            for (int k = c.length - 1; k >= 0; k--) {
                if(p[pi + c.length] == c[k]){
                    in = k;
                    break;
                }
            }
            pi = pi + c.length - in;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Main().strStr2("mississippi", "issip"));
        System.out.println(new Main().strStr2("aaaaa", "bba"));
        System.out.println(new Main().strStr2("a", "a"));
    }
}
