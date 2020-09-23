package com.zeki.letcode.questiontop50.question42;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * @author Zeki
 * @date 2020/9/23 9:25
 */
public class Main {

    public int trap(int[] height) {
        int res = 0;
        int preH = 0;
        int left = 0;
        int right = 0;
        int tempRes = 0;
        while (left < height.length - 1){
            right = left + 1;
            if(height[left] <= height[left + 1]){
                tempRes = Math.min(height[left + 1],preH) - height[left];
                res = res + Math.max(tempRes, 0);
                preH = height[left];
                left++;
            }else {
                //找出下一个大于 height[left] 的值
                right = left + 1;
                while (right < height.length){
                    if(height[right] < height[left]){
                        right++;
                    }else {
                        break;
                    }
                }
                if(right >= height.length){
                    //未找到
                    break;
                }
                if(preH <= height[left]){
                    preH = height[left];
                }
                int tempMaxH = Math.min(preH,height[right]);
                tempRes = 0;
                while (left < right){
                    tempRes = tempRes + tempMaxH - height[left];
                    left++;
                }
                res = res + tempRes;
                preH = height[left-1];
            }
        }
        return res;
    }

    public int trap2(int[] height) {
        int res = 0;
        int preH = 0;
        int left = 0;
        int right = 0;
        int tempRes = 0;
        int tempMaxEfH = 0;
        while (left < height.length - 1){
            //找出最后一个大于 height[left] 的值
            int tempMaxRight = -1;
            int tempMax = height[left];
            right = left + 1;
            while (right < height.length){
                if(height[right] >= tempMax){
                    if(height[right] == tempMax){
                        //如果当前值小于
                        if(tempMaxRight == -1){
                            tempMaxRight = right;
                            tempMax = height[right];
                        }
                    }else {
                        tempMaxRight = right;
                        tempMax = height[right];
                    }

                }
                if(tempMaxRight != -1 && height[right] < tempMax && tempMax >= preH){
                    break;
                }
                right++;
            }
            if(tempMaxRight == -1){
                //未找到 left + 1
                preH = height[left];
                left++;
                continue;
            }else {
                //设置right为最后一个大于left的值
                right = tempMaxRight;
            }
            //计算当前最高有效边界
            if(preH <= height[left]){
                preH = height[left];
            }
            tempMaxEfH = Math.min(preH,height[right]);
            //计算从left到right之前的所有容量
            tempRes = 0;
            while (left < right){
                int w = tempMaxEfH - height[left];
                tempRes = tempRes + (Math.max(w, 0));
                left++;
            }
            res = res + tempRes;
            preH = height[left-1];
        }
        return res;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = new int[]{0,7,1,4,6}; //7
        int[] nums1 = new int[]{0,1,0,2,1,0,1,3,2,1,2,1}; //6
        int[] nums2 = new int[]{4,2,0,3,2,5}; //9
        int[] nums3 = new int[]{2,8,5,5,6,1,7,4,5};// 12
        System.out.println(main.trap2(nums));
        System.out.println(main.trap2(nums1));
        System.out.println(main.trap2(nums2));
        System.out.println(main.trap2(nums3));
    }
}
