package com.zeki.letcode.questiontop25.question23;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author Zeki
 * @date 2020/9/8 9:28
 */
public class Main {


    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length <= 0){
            return null;
        }
        int size = lists.length;
        while (size > 1){
            for (int i = 0; i < size; i++) {
                ListNode l1 = i * 2 < size ? lists[i * 2] : null;
                ListNode l2 = i * 2 + 1 < size ? lists[i * 2 + 1] : null;
                ListNode node = mergeTwoLists(l1, l2);
                lists[i] = node;
            }
            size = (size / 2) + (size % 2);
        }
        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode nl = new ListNode(-1);
        ListNode temp = nl;
        while (l1 != null && l2 != null){
            if(l1.val > l2.val){
                temp.next = l2;
                l2 = l2.next;
            }else {
                temp.next = l1;
                l1 = l1.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null ? l2 : l1;
        return nl.next;
    }

    /**
     * 优化
     * @param lists
     * @return
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        if(lists == null || lists.length <= 0){
            return null;
        }

        ListNode head = new ListNode(-1);
        ListNode temp = head;
        Integer min = null;
        int index = -1;
        //查找剩余最小元素
        while (true){
            min = null;
            index = -1;
            //找出头元素当前最小节点
            for (int i = 0; i < lists.length; i++) {
                if(lists[i] != null){
                    if(min == null){
                        min = lists[i].val;
                        index = i;
                    }else if(lists[i].val < min){
                        min = lists[i].val;
                        index = i;
                    }
                }
            }
            if(index == -1){
                //说明所有元素已经为空
                break;
            }else {
                temp.next = lists[index];
                lists[index] = lists[index].next;
                temp = temp.next;
            }

        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode tempL1 = l1;
        for (int i = 3; i <= 10; i+=2) {
            ListNode temp = new ListNode(i);
            tempL1.next = temp;
            tempL1 = temp;
        }

        ListNode l2 = new ListNode(2);
        ListNode tempL2 = l2;
        for (int i = 4; i <= 10; i+=2) {
            ListNode temp = new ListNode(i);
            tempL2.next = temp;
            tempL2 = temp;
        }

        ListNode l3 = new ListNode(2);
        ListNode tempL3 = l3;
        for (int i = 4; i <= 10; i+=2) {
            ListNode temp = new ListNode(i);
            tempL3.next = temp;
            tempL3 = temp;
        }

        ListNode l4 = new ListNode(2);
        ListNode tempL4 = l4;
        for (int i = 4; i <= 10; i+=2) {
            ListNode temp = new ListNode(i);
            tempL4.next = temp;
            tempL4 = temp;
        }

//        outLinkList(l1);
//        outLinkList(l2);

        ListNode node = new Main().mergeKLists(new ListNode[]{l1, l2,null,l3,l4});

        outLinkList(node);
    }

    public static void outLinkList(ListNode head) {
        ListNode temp = head;
        while (temp != null){
            System.out.printf(">%d", temp.val);
            temp = temp.next;
        }
        System.out.println();
    }



}
