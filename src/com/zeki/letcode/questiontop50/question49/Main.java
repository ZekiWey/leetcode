package com.zeki.letcode.questiontop50.question49;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * @author Zeki
 * @date 2020/9/27 11:15
 */
public class Main {

    /**
     * 方法一字符串排序后当key放入map(String,List<String>)中
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        //排序后map
        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            //排序
            String key = sortStr(strs[i].toCharArray());
            List<String> linkList = map.get(key);
            if(linkList == null){
                linkList = new LinkedList<>();
                map.put(key,linkList);
            }
            linkList.add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

    private String sortStr(char[] chars){
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if(chars[i] - chars[j] > 0){
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
            }
        }
        return new String(chars);
    }

    public static final Map<Character,Integer> charMaps = new HashMap<>(26);
    static {
        charMaps.put('a',2);charMaps.put('g',17);charMaps.put('m',41);charMaps.put('s',67);charMaps.put('y',97);
        charMaps.put('b',3);charMaps.put('h',19);charMaps.put('n',43);charMaps.put('t',71);charMaps.put('z',101);
        charMaps.put('c',5);charMaps.put('i',23);charMaps.put('o',47);charMaps.put('u',73);
        charMaps.put('d',7);charMaps.put('j',29);charMaps.put('p',53);charMaps.put('v',79);
        charMaps.put('e',11);charMaps.put('k',31);charMaps.put('q',59);charMaps.put('w',83);
        charMaps.put('f',13);charMaps.put('l',37);charMaps.put('r',61);charMaps.put('x',89);
    }

    /**
     * 26个字符每个对应一个质数 求和做key放入map(Integer,List<String>)
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        //排序后map
        Map<Long,List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            //排序
            Long key = getHashCode(strs[i]);
            List<String> linkList = map.get(key);
            if(linkList == null){
                linkList = new LinkedList<>();
                map.put(key,linkList);
            }
            linkList.add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

    private Long getHashCode(String s){
        Long sum = 1L;
        for (int i = 0; i < s.length(); i++) {
            sum *= charMaps.get(s.charAt(i));
        }
        return sum;
    }


    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat","age","he"};
        Main main = new Main();
        System.out.println(main.groupAnagrams1(strs));
        String s = "bca";
    }
}
