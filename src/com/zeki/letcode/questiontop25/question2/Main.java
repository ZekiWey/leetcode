package com.zeki.letcode.questiontop25.question2;

import java.math.BigDecimal;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(0);
        l1.next = l11;
        ListNode l12 = new ListNode(0);
        l11.next = l12;
        ListNode l13 = new ListNode(0);
        l12.next = l13;
        ListNode l14 = new ListNode(0);
        l13.next = l14;
        ListNode l15 = new ListNode(0);
        l14.next = l15;
        ListNode l16 = new ListNode(0);
        l15.next = l16;
        ListNode l17 = new ListNode(1);
        l16.next = l17;

        ListNode l2 = new ListNode(1);
        ListNode l21 = new ListNode(2);
        l2.next = l21;
        ListNode l22 = new ListNode(3);
        l21.next = l22;

        ListNode sumNode = addTwoNumbers2(l1, l2);


        String sum = "";
        System.out.println(sumNode);
        while (sumNode != null){
            sum = sum + String.valueOf(sumNode.val);
            sumNode = sumNode.next;
        }

        System.out.println(sum);
    }
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode head = temp;

        ListNode temp1 = l1;
        ListNode temp2 = l2;

        int iOver10 = 0;
        while(temp1 != null || temp2 != null){
            ListNode temp3 = new ListNode(0);
            int val1 = temp1 == null ? 0 : temp1.val;
            int val2 = temp2 == null ? 0 : temp2.val;
            int sum = val1 + val2 + iOver10;
            if(sum >= 10){
                temp3.val = sum - 10;
                iOver10 = 1;
            }
            else{
                temp3.val = sum;
                iOver10 = 0;
            }

            temp.next = temp3;
            temp = temp3;

            temp1 = temp1 == null?null:temp1.next ;
            temp2 = temp2 == null?null:temp2.next;
        }

        if(iOver10 == 1){
            ListNode temp3 = new ListNode(1);
            temp.next = temp3;
            temp = temp3;
        }
        return head.next;
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //计算总和
        BigDecimal sum = new BigDecimal(assemblyListNodeCycle(l1)).add(new BigDecimal(assemblyListNodeCycle(l2)));
        String[] sumStr = sum.toString().split("");

        //将计算结果生成链表
        ListNode rootNode = null,sumNode = null;
        for (int i = sumStr.length-1; i >= 0; i--) {
            if(sumNode == null) {
                sumNode = new ListNode(Integer.parseInt(sumStr[i]));
                rootNode = sumNode;
            }else {
                sumNode.next = new ListNode(Integer.parseInt(sumStr[i]));
                sumNode = sumNode.next;
            }
        }
        return rootNode;
    }

    /**
     * 递归实现链表的拼接
     * @param listNode
     * @return
     */
    public static String assemblyListNodeRecursive(ListNode listNode){
        if(listNode.next == null){
            return String.valueOf(listNode.val);
        }
        return assemblyListNodeRecursive(listNode.next) + String.valueOf(listNode.val);
    }

    /**
     * 循环实现链表的拼接
     * @param listNode
     * @return
     */
    public static String assemblyListNodeCycle(ListNode listNode){
        String num = "";
        while (listNode != null){
            num = num + String.valueOf(listNode.val);
            listNode = listNode.next;
        }
        return new StringBuilder(num).reverse().toString();
    }
}
