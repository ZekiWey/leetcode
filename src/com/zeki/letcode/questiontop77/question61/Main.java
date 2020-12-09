package com.zeki.letcode.questiontop77.question61;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 * @author Zeki
 * @date 2020/10/12 15:31
 */
public class Main {

    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0){
            return head;
        }
        int len = 0;
        ListNode end = head;
        ListNode temp = head;
        //计算长度
        while (temp != null){
            len++;
            end = temp;
            temp = temp.next;
        }
        if(len == 0 || len == 1){
            return head;
        }
        k = k % len;
        for (int i = 0; i < k; i++) {
            end.next = head;
            temp = head;
            while (temp != null){
                if(temp.next == end){
                    temp.next = null;
                    break;
                }
                temp = temp.next;
            }
            head = end;
            end = temp;
        }
        return head;
    }

    /**
     * 1.先初始化 tempSum 为 0! ，结果sum初始化为 0。
     * 2.循环 1 - n，
     * 当i = 1  需要求  1！，1！ =  0! x  1，即（tempSum  x  i）， 求出1!后,将1! 保存到tempSum 并累加到sum中
     * 当i = 2  需要求  2！，2！ =  1! x  2，即（tempSum  x  i）， 求出2!后,将1! 保存到tempSum 并累加到sum中
     *
     *
     * @param n
     * @return
     */
    public double sum(int n){
        int i;
        double sum = 0,tempSum = 1;

        for (i = 1; i <= n; i++) {
            tempSum = tempSum * i;
            sum = sum + tempSum;
        }
        System.out.println(sum);
        return sum;
    }

    public double sum1(int n){
        int i;
        double sum = 0;

        for (i = 1; i <= n; i++) {
            //求 1-i 的阶乘
            double f = 1;
            for (int j = 1; j <= i; j++) {
                f = f * j;
            }
            //累加到结果中
            sum = sum + f;
        }
        System.out.println(sum);
        return sum;
    }

    public static void main(String[] args) {
        ListNode build = build(new int[]{0, 1, 2});
        Main main = new Main();
        main.sum(4);
        main.sum1(4);
        //ListNode listNode = main.rotateRight(build, 5);
        //outLinkList(listNode);
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
