package com.zeki.letcode.questiontop77.question75;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * @author Zeki
 * @date 2020/11/12 14:28
 */
public class Main {

    public void sortColors(int[] nums) {
        int a = 0,b = 0,c = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                a++;
            }else if(nums[i] == 1){
                b++;
            }else {
                c++;
            }
        }
        int index = 0;
        for (int i = 0; i < a; i++) {
            nums[index] = 0;
            index++;
        }
        for (int i = 0; i < b; i++) {
            nums[index] = 1;
            index++;
        }
        for (int i = 0; i < c; i++) {
            nums[index] = 2;
            index++;
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}
