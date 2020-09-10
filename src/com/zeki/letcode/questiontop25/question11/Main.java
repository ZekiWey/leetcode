package com.zeki.letcode.questiontop25.question11;

public class Main {
    public static void main(String[] args) {
        System.out.println(maxArea2(new int[]{1,0}));
    }
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int len = height.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if(i == j){
                    System.out.println(i);
                }
                int area = (j - i) * (Math.min(height[i],height[j]));
                if(area > maxArea){
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }
    public static int maxArea2(int[] height) {
        int maxArea = 0;
        int len = height.length;
        int l = 0,r = len-1;
        for (int i = 0; i < len; i++) {
            int area = (r - l) * Math.min(height[l],height[r]);
            if(area > maxArea){
                maxArea = area;
            }
            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxArea;
    }
}
