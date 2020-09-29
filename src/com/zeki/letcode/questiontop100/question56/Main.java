package com.zeki.letcode.questiontop100.question56;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 提示：
 * intervals[i][0] <= intervals[i][1]
 * @author Zeki
 * @date 2020/9/29 17:58
 */
public class Main {

    public int[][] merge(int[][] intervals) {

        return null;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][] {{1,3},{2,6},{8,10},{15,18}};
        Main main = new Main();
        main.merge(intervals);
    }

    /**
     * z  z y  y  z   
     * 1，2，3，6，8，10
     * 1，2，3，5，8，10，15，18
     *
     * 1，3
     * 2，5
     * 4，6
     * 8，10
     * 15，18
     */
}
