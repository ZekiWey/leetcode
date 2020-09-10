package com.zeki.letcode.questiontop50.question30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Zeki
 * @date 2020/9/10 11:35
 */
public class Main {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(words.length == 0){
            return res;
        }
        int unitLen = words[0].length();
        int l = words.length * unitLen;

        if(s.length() < l){
            return res;
        }
        int loop = s.length() - l;

        Map<String,Integer> countMap = new HashMap<>(words.length);
        for (String word : words) {
            countMap.put(word,countMap.getOrDefault(word,0) + 1);
        }
        for (int i = 0; i <= loop; i++) {

            Map<String,Integer> tempMap = new HashMap<>(words.length);
            for (int k = 0; k < words.length; k++) {
                String subStr = s.substring(i + k * unitLen,i + k  * unitLen + unitLen);
                if(countMap.get(subStr) != null){
                    tempMap.put(subStr,tempMap.getOrDefault(subStr,0) + 1);
                }else {
                    //i = i + (k + 1) * unitLen - 1;
                    break;
                }
            }
            boolean flag = true;
            if(tempMap.keySet().size() == countMap.keySet().size()){
                for (String s1 : tempMap.keySet()) {
                    if(!tempMap.get(s1).equals(countMap.get(s1))){
                        flag = false;
                        break;
                    }
                }
            }else {
                flag = false;
            }
            if(flag){
                res.add(i);
            }
        }

        return res;
    }


    public List<Integer> findSubstring1(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(words.length == 0){
            return res;
        }
        int unitLen = words[0].length();
        int wordNum = words.length;
        int subLen = wordNum * unitLen;


        if(s.length() < subLen){
            return res;
        }

        Map<String,Integer> countMap = new HashMap<>(words.length);
        for (String word : words) {
            countMap.put(word,countMap.getOrDefault(word,0) + 1);
        }

        for (int i = 0; i < unitLen; i++) {
            Map<String,Integer> tempMap = new HashMap<>(words.length);
            int count = 0;
            for (int j = i; j < s.length() - unitLen + 1;j += unitLen) {
                String subWord = s.substring(j,j + unitLen);
                Integer integer = countMap.get(subWord);
                if(integer == null){
                    //不存在词库中直接后移一个单词的位置
                    //重置
                    count = 0;
                    tempMap.clear();
                }else {
                    Integer exist = tempMap.getOrDefault(subWord, 0);
                    if(exist.equals(integer)){
                        //超过最大限制

                        while (countMap.get(subWord) <= tempMap.get(subWord)){
                            int firstIndex = j - (count) * unitLen;
                            String firstString = s.substring(firstIndex, firstIndex + unitLen);
                            Integer integer1 = tempMap.get(firstString);

                            tempMap.put(firstString,integer1 - 1);
                            count--;
                        }
                    }
                    tempMap.put(subWord,tempMap.getOrDefault(subWord,0) + 1);
                    count++;
                    if(count == wordNum){
                        int firstIndex = j - (wordNum - 1) * unitLen;
                        res.add(firstIndex);
                        count--;
                        String firstString = s.substring(firstIndex, firstIndex + unitLen);
                        tempMap.put(firstString,tempMap.get(firstString) - 1);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        String s = "barfoofoobarthefoobarman";
//        String[] words = new String[]{"bar","foo","the"};
        //String s = "barfoothefoobarman";
        //String[] words = new String[]{"foo","bar"};
        String s = "aaa";
        String[] words = new String[]{"a","a"};
        System.out.println(new Main().findSubstring1(s,words));
    }
}
