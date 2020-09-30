package com.zeki.letcode.questiontop100.question56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
        if(intervals.length == 0){
            return intervals;
        }
        //根据区间首元素和尾元素从小到大排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                int i = interval1[0] - interval2[0];
                if(i > 0){
                    return 1;
                }
                if(i == 0){
                    return interval1[1] - interval2[1];
                }
                return -1;
            }
        });
        /*for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if(intervals[i][0] > intervals[j][0]){
                    //交换
                    int[] temp = intervals[i];
                    intervals[i] = intervals[j];
                    intervals[j] = temp;
                }
                if(intervals[i][0] == intervals[j][0]){
                    if(intervals[i][1] > intervals[j][1]){
                        //交换
                        int[] temp = intervals[i];
                        intervals[i] = intervals[j];
                        intervals[j] = temp;
                    }
                }
            }
        }*/
        List<int[]> res = new ArrayList<>();
        int begin = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] <= end){
                end = intervals[i][1] > end ? intervals[i][1] : end;
                continue;
            }
            res.add(new int[]{begin,end});
            begin = intervals[i][0];
            end = intervals[i][1];
        }
        res.add(new int[]{begin,end});

        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][] {{8,10},{1,3},{15,18},{2,6}};
        int[][] intervals1 = new int[][] {{1,4}};
        Main main = new Main();
        int[][] merge = main.merge(intervals);
        for (int i = 0; i < merge.length; i++) {
            System.out.println(Arrays.toString(merge[i]));
        }
    }

    /**
     * 1  6 8 10 15 18
     *
     * 1，3
     * 2，5
     * 4，6
     * 8，10
     * 15，18
     */
}
