package com.zeki.letcode.questiontop77.question71;

import java.util.Stack;

/**
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；
 * 此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；
 * 两者都可以是复杂相对路径的组成部分。
 * 更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
 *
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。
 * 最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 *
 * @author Zeki
 * @date 2020/10/27 11:35
 */
public class Main {

    /**
     * / = /
     * /.. = /
     * /. = /
     * /a/.. = /
     * /a/. = /a
     * /a/../c = /c
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        //拆分字符串
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : split) {
            if(s.trim().equals("")){
                continue;
            }
            if(s.equals("..")){
                if(!stack.empty()){
                    stack.pop();
                }
            } else if(s.equals(".")){
                //nothing
            } else {
                stack.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        if(stack.empty()){
            sb.append('/');
        }else {
            for (Object o : stack.toArray()) {
                sb.append('/').append(o.toString());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.simplifyPath("/../"));
    }
}
