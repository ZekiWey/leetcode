package com.zeki.letcode.questiontop25.question25;

/**
 * @author Zeki
 * @date 2020/9/8 15:32
 */
public class Main {

    public ListNode reverseKGroup(ListNode head,int k) {
        if(head == null || k <= 1){
            return head;
        }
        ListNode res = new ListNode(-1);
        ListNode temp = head;
        //计数器
        int sum = 1;
        //记录上一组反转后的尾节点
        ListNode preNode = res;
        //记录本组的反转前的首节点 用于逆序链表使用
        ListNode tempLeft = null;
        //记录下一组的首节点 用于中断链表排序使用
        ListNode tempNext = null;

        while (temp != null){
            if(sum < k){
                if(sum == 1){
                    tempLeft = temp;
                }
                sum++;
                temp = temp.next;
            }else {
                //保存下一组的首节点
                tempNext = temp.next;
                //将链表从此处断开
                temp.next = null;
                //逆序链表
                ListNode reverse = reverse(tempLeft);
                //将上一组尾节点指向逆序后的首节点
                preNode.next = reverse;
                //准备开始下一组循环
                //重新设置preNode为当前组的尾节点
                preNode = tempLeft;
                //暂时拼接剩余未处理的链表到逆序后的尾节点 防止剩余节点长度 < k
                preNode.next = tempNext;
                //清空计数
                temp = tempNext;
                sum = 1;
            }
        }
        return res.next;
    }

    public ListNode reverse(ListNode head){
        ListNode cur = head;
        ListNode tmp, prev = null;
        while (cur != null){
            tmp = cur.next;
            cur.next  = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode build = build(new int[]{1, 2, 3, 4, 5});
        outLinkList(build);
        ListNode node = new Main().reverseKGroup(build, 2);
        outLinkList(node);
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
