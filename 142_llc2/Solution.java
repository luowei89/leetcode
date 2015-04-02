/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode p3 = head;
        while(p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2){
                break;
            }
        }
        if(p1 != p2){
            return null;
        }
        p1 = p1.next;
        while(p3 != p1){
            if(p1 == p2){
                p3 = p3.next;
            }
            p1 = p1.next;
        }
        return p3;
    }
}