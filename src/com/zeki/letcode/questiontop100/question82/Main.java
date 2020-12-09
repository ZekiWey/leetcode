package com.zeki.letcode.questiontop100.question82;

/**
 * @author Zeki
 * @date 2020/12/5 17:04
 */
public class Main {



    public static void main(String[] args) {
        Main main = new Main();
        //ListNode listNode = main.bulidList(new int[]{1, 1, 2, 3, 4, 5, 6});
        ListNode listNode = main.bulidList(new int[]{1, 1});
        main.pList(listNode);
        ListNode listNode1 = main.deleteDuplicates(listNode);
        main.pList(listNode1);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode temp = head;
        int curNum = temp.val,curNumCount = 1;
        ListNode perNode = null,firstNode = temp;
        temp = temp.next;

        while (temp != null){
            if(temp.val == curNum){
                curNumCount++;
            }else {
                if(curNumCount > 1){
                    if(perNode != null){
                        perNode.next = temp;
                    }
                }else {
                    if(perNode == null){
                        head = firstNode;
                    }
                    perNode = firstNode;
                }
                firstNode = temp;
                curNum = temp.val;
                curNumCount = 1;
            }
            temp = temp.next;
        }
        if(curNumCount > 1){
            if(perNode != null){
                perNode.next = null;
            }else {
                head = null;
            }
        }else {
            if(perNode == null){
                head = firstNode;
            }
        }
        return head;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    private ListNode bulidList(int[] nums){
        if(nums == null || nums.length <= 0){
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode temp = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode next = new ListNode(nums[i]);
            temp.next = next;
            temp = next;
        }
        return head;
    }

    private void pList(ListNode head){
        if(head == null){
            System.out.println("[]");
            return;
        }
        ListNode temp = head;
        System.out.printf("[");
        while (temp != null){
            if(temp.next != null){
                System.out.printf(" %d ,",temp.val);
            }else {
                System.out.printf(" %d ",temp.val);
            }
            temp = temp.next;
        }
        System.out.printf("]\n");
    }
}
