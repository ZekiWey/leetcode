package com.zeki.letcode.questiontop77.question68;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 *
 * @author Zeki
 * @date 2020/10/26 14:05
 */
public class Main {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int p = 0;
        while (p < words.length){
            //选择一行的单词
            int currP = p;
            int currLen = 0;
            int wordNum = 0;

            while (currLen < maxWidth && currP < words.length){
                if(currLen + wordNum + words[currP].length() > maxWidth){
                    break;
                }
                currLen = currLen + words[currP].length();
                wordNum++;
                currP++;
            }
            //需要添加空格的数量
            int spaceNumSum = maxWidth - currLen;
            //间隙数量
            int intervalNum = wordNum - 1 == 0 ? 1 : wordNum - 1;

            StringBuilder sb = new StringBuilder();
            for(;p < currP;p++){
                //添加单词
                sb.append(words[p]);
                //添加空格
                if(currP >= words.length){
                    //最后一行左对齐
                    if(p < currP - 1){
                        sb.append(' ');
                    }else {
                        //最后一个单词补齐右边空格
                        int num = maxWidth - sb.length();
                        for (int i = 0; i < num; i++) {
                            sb.append(' ');
                        }
                    }
                }else {
                    if(intervalNum > 0){
                        int tempSpaceNum;
                        if(spaceNumSum % intervalNum == 0){
                            tempSpaceNum = spaceNumSum / intervalNum;
                        }else {
                            //采用四舍五入原则
                            tempSpaceNum = spaceNumSum / intervalNum + 1;
                        }
                        for (int i = 0; i < tempSpaceNum; i++) {
                            sb.append(' ');
                        }
                        spaceNumSum = spaceNumSum - tempSpaceNum;
                        intervalNum--;
                    }
                }
            }
            res.add(sb.toString());

        }
        return res;
    }


    public static void main(String[] args) {
        Main main = new Main();
        String[] words = new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        List<String> list = main.fullJustify(words, 20);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
