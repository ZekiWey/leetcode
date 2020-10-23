package com.zeki.letcode.questiontop25.question3;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("dvdf"));
    }
    public static int lengthOfLongestSubstring(String s) {
        //空串直接返回0
        if(s.equals("")){
            return 0;
        }
        //分隔数组
        char[] split = s.toCharArray();
        int maxLength = 0,tempLength = 0;
        String temp = "";
        //循环字符数组
        for (char s1 : split) {
            int index = temp.indexOf(s1);
            //如果下一个字符在当前字串中存在
            if(index >= 0){
                //如果之前字串的长度是目前最大的，则保留
                if(tempLength > maxLength){
                    maxLength = tempLength;
                }
                //去掉重复的部分并重新计算长度
                temp = temp.substring(index + 1,temp.length()) + s1;
                tempLength = temp.length();
            }else {
                temp = temp + s1;
                tempLength++;
            }
        }
        //对比最后一个字串是否是最大长度字串
        if(tempLength > maxLength){
            maxLength = tempLength;
        }
        return maxLength;
    }
    //max 2       i1
    //dvdf  v2 d3

    public static int lengthOfLongestSubstring2(String s) {
       int maxLength = 0;
       Map<Character,Integer> map = new HashMap<>();
       for (int i=0,j=0;j < s.length();j++){
           if(map.containsKey(s.charAt(j))){
               i = Math.max(map.get(s.charAt(j)), i);
           }
           maxLength=Math.max(maxLength,j - i + 1);
           map.put(s.charAt(j),j+1);

       }
       return maxLength;
    }
}
