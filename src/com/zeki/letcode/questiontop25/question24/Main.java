package com.zeki.letcode.questiontop25.question24;

/**
 * @author Zeki
 * @date 2020/9/8 11:19
 */
public class Main {

    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode left = head;
        ListNode right = null;
        ListNode temp = head.next;
        ListNode preNode = null;

        while (temp != null){
            if(left == null){
                left = temp;
                temp = temp.next;
            }else {
                right = temp;
                //交换左右左右节点指向
                left.next = right.next;
                right.next = left;
                //改变上一组交换后右节点的指向
                if(preNode == null){
                    head = right;
                }else {
                    preNode.next = right;
                }
                //设置当前左节点为本组的右节点
                preNode = left;
                //到下一组元素
                temp = left.next;
                left = null;
                right = null;
            }
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode build = build(new int[]{1, 2, 3, 4,5,6});

        ListNode listNode = new Main().swapPairs(build);

        outLinkList(listNode);

    }

    public static ListNode build(int[] nums){
        if(nums == null || nums.length == 0){
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode temp = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode n = new ListNode(nums[i]);
            temp.next = n;
            temp = temp.next;
        }
        return head;
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
