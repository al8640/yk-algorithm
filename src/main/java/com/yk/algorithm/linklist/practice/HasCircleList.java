package com.yk.algorithm.linklist.practice;

import com.yk.algorithm.linklist.ListNode;

/**
 * @author ke.yang1
 * @description
 * @date 2021/7/8 11:10 下午
 */
public class HasCircleList {
    public boolean hasCircle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while(fast != null  && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
