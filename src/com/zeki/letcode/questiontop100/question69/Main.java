package com.zeki.letcode.questiontop100.question69;

/**
 *
 * @author Zeki
 * @date 2020/10/27 9:22
 */
public class Main {

    public int mySqrt(int x) {
        long s;
        int i = 0;
        int xx = x / 2 + 1;
        for (i = 0; i <= xx; i++) {
            s = (long)i * (long)i;
            if(s >= x){
                if(s == x){
                    return i;
                }
                return i - 1;
            }
        }
        return i;
    }

    public int mySqrt1(int x) {
        //
        int l = 0,r = x,ans = -1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.mySqrt1(2147483647));
    }
}
