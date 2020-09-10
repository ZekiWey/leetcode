package com.zeki.letcode.questiontop25.question13;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(romanToInt("IXVII"));
    }

    private static int romanToInt(String s){
        Map<Character,Integer> map = new HashMap<>(7);
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int num = 0;
        int len = s.length();
        num = num + map.get(s.charAt(len -1));
        for (int i = len-2;i >= 0; i--) {
            int value = map.get(s.charAt(i));
            int preValue = map.get(s.charAt(i+1));
            if(value < preValue){
                num = num - value;
            }else {
                num = num + value;
            }
        }
        return num;
    }

}
