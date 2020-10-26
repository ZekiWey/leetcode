package com.zeki.letcode.questiontop100.question65;

/**
 * 65.验证给定的字符串是否可以解释为十进制数字。
 * @author Zeki
 * @date 2020/10/19 17:48
 */
public class Main {
    public boolean isNumber(String s) {
        s = s.trim();
        s = s.toLowerCase();

        if(s.length() == 0){
            return false;
        }

        boolean f = true;
        boolean point = false;
        boolean e = false;
        int ep = -1;

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if(c < '0' || c > '9'){
                if(c == '-' || c == '+'){
                    if(e) {
                        if (i != ep + 1 || i >= s.length() - 1) {
                            f = false;
                            break;
                        }
                    }else {
                        if(i != 0 || i >= s.length() - 1){
                            f = false;
                            break;
                        }
                        //后一位必须是数字或小数点
                        int t = s.charAt(i + 1);
                        if(t < '0' || t > '9'){
                            if(t != '.'){
                                f = false;
                                break;
                            }
                        }

                    }
                } else if(c == '.'){
                    if(point || e){
                        f = false;
                        break;
                    }else {
                        if(i == 0 && i >= s.length() - 1){
                            f = false;
                            break;
                        }
                        //前一位和后一位必须是数字
                        int t;
                        boolean pism = false;
                        if (i > 0){
                            t = s.charAt(i - 1);
                            if(t < '0' || t > '9'){
                                if( t != '-' && t != '+'){
                                    f = false;
                                    break;
                                }
                            }else {
                                pism = true;
                            }
                        }
                        if(i < s.length() - 1) {
                            t = s.charAt(i + 1);
                            if (t < '0' || t > '9') {
                                if (t != 'e' || !pism) {
                                    f = false;
                                    break;
                                }
                            }
                        }else {
                            if(!pism){
                                f = false;
                                break;
                            }
                        }
                    }
                    point = true;
                } else if(c == 'e'){
                    if(e){
                        f = false;
                        break;
                    }else {
                        if(i == 0 || i >= s.length() - 1){
                            f = false;
                            break;
                        }
                    }
                    e = true;
                    ep = i;
                } else {
                    //其他字符
                    f = false;
                    break;
                }
            }
        }
        return f;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.isNumber("  +e1  "));
    }
}
