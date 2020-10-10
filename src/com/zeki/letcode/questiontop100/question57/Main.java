package com.zeki.letcode.questiontop100.question57;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 * 示例
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 *
 *
 * @author Zeki
 * @date 2020/10/10 10:40
 */
public class Main {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        //将新的区间插入到有序数组中
        int i = 0;
        for (i = 0; i < intervals.length; i++) {
            if(newInterval[0] <= intervals[i][0]){
                if(newInterval[0] == intervals[i][0]){
                    if(newInterval[1] < intervals[i][1]){
                        res.add(newInterval);
                        res.add(intervals[i]);
                    }else {
                        res.add(intervals[i]);
                        res.add(newInterval);
                    }
                }else {
                    res.add(newInterval);
                    res.add(intervals[i]);
                }
                break;
            }
            res.add(intervals[i]);
        }

        if(res.size() == 0 || i >= intervals.length){
            res.add(newInterval);
        }else {
            for (i = i + 1; i < intervals.length; i++) {
                res.add(intervals[i]);
            }
        }

        int[][] ints = res.toArray((new int[res.size()][]));

        res = new ArrayList<>();
        int begin = ints[0][0];
        int end = ints[0][1];
        for (i = 1; i < ints.length; i++) {
            if(ints[i][0] <= end){
                end = ints[i][1] > end ? ints[i][1] : end;
                continue;
            }
            res.add(new int[]{begin,end});
            begin = ints[i][0];
            end = ints[i][1];
        }
        res.add(new int[]{begin,end});

        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][] {{2,6},{7,9}};
        int[] newInterval  = new int[] {15,18};
        Main main = new Main();
        int[][] insert = main.insert(intervals, newInterval);
        for (int i = 0; i < insert.length; i++) {
            System.out.println(Arrays.toString(insert[i]));
        }
    }
}
