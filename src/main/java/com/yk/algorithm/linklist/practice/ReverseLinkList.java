package com.yk.algorithm.linklist.practice;

import com.yk.algorithm.linklist.ListNode;

/**
 * @author ke.yang1
 * @description
 * @date 2021/7/6 10:35 下午
 */
public class ReverseLinkList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode tmp = curr.next;
            curr.next = curr;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }

    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }

}
