package com.zeki.letcode.questiontop25.question19;

/**
 * @author Zeki
 * @date 2020/9/7 13:27
 */
public class Main {

    /**
     * 两次遍历
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // n-1 > n-2
        //统计长度
        ListNode temp = head;
        int size = 0;
        while (temp != null){
            size++;
            temp = temp.next;
        }
        if(size == n){
            head = head.next;
            return head;
        }

        temp = head;
        int num = 0;
        ListNode n1 = null;
        while (temp != null){
            num++;
            if(size - num == n){
                n1 = temp;
            }
            temp = temp.next;
        }
        if(n1 != null){
            n1.next = n1.next.next;
        }else {
            return null;
        }
        return head;
    }


    /**
     * 递归解法
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode temp = head;
        int size = find(temp, n);
        //如果链表只有一个节点或没有节点 则返回null
        if(size <= 1){
            return null;
        }
        //如果删除的是第一个元素
        if(size == n){
            head = head.next;
        }
        return head;
    }

    /**
     * 快慢指针
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode p = head;
        ListNode q = head;
        int s = n;
        while (p != null){
            p = p.next;
            if(s < 0){
                q = q.next;
            }
            s--;
        }
        if(s == 0){
            return q.next;
        }
        if(q.next == null){
            return null;
        }
        q.next = q.next.next;
        return head;
    }

    /**
     * 递归改变倒数第N个节点的前一个节点为 倒数第N个节点的后一个节点
     * @param node 当前节点
     * @param n N
     * @return 链表长度
     */
    private int find(ListNode node,int n){
        if(node == null){
            return 0;
        }
        if(node.next == null){
            return 1;
        }
        int i = find(node.next, n) + 1;
        if(i == n + 1){
            node.next = node.next.next;
        }
        return i;
    }

    public static void main(String[] args) {
        //1->2->3->4->5
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 1; i++) {
            ListNode node = new ListNode(i);
            temp.next = node;
            temp = node;
        }
        temp = head;
        while (temp != null){
            System.out.println(">" + temp.val);
            temp = temp.next;
        }

        System.out.println("-------");

        head = new Main().removeNthFromEnd3(head, 1);

        temp = head;
        while (temp != null){
            System.out.println(">" + temp.val);
            temp = temp.next;
        }
    }
}
