package com.yk.algorithm.main.hot100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author al864
 */
public class Question142 {
    /**
     * 哈希表发
     * @param head
     * @return
     */
    public ListNode detectCycle1(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode pos = head;
        while(pos != null){
            if(set.contains(pos)){
                return pos;
            }else{
                set.add(pos);
            }
            pos = pos.next;
        }
        return  null;
    }

    /**
     * 快慢指针法
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        ListNode f = head;
        ListNode s = head;
        while(f != null && f.next != null){
            s = s.next;
            f = f.next.next;
            if(f == s){
                ListNode ptr = head;
                while(ptr != s){
                    ptr = ptr.next;
                    s = s.next;
                }
                return ptr;
            }
        }
        return  null;
    }

    public static void main(String[] args) {

    }

}

