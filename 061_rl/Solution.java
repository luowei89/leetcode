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
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null){
            return null;
        }
        ListNode p = head;
        ListNode last = head;
        int num = 0;
        while(last.next != null){
            last = last.next;
            num++;
        }
        
        for(int i = 0; i < num-n%(num+1); i++){
            p = p.next;
        }
        
        if(p != null){
            last.next = head;
            head = p.next;
            p.next = null;          
        }
        return head;
    }
}