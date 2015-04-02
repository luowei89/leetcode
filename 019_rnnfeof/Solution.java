/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
           return null; 
        }
        ListNode nth = head;
        ListNode p = head;
        int counter = 0;
        while(counter < n){
            p = p.next;
            counter++;
        }
        if( p == null){
            return head.next;
        }
        p = p.next;
        while(p != null){
            p = p.next;
            nth = nth.next;
        }
        nth.next = nth.next.next;
        return head;
    }
}