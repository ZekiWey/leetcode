package com.zeki.letcode.questiontop25.question21;

/**
 * @author Zeki
 * @date 2020/9/7 15:23
 */
public class Main {

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

        ListNode l3 = new Main().mergeTwoLists(l1, l2);

        outLinkList(l1);
        outLinkList(l2);
        outLinkList(l3);

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
