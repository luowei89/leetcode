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
    public ListNode sortList(ListNode head) {
        if(head == null){
            return null;
        }
        int count = 0;
        ListNode p = head;
        while(p!= null){
            count++;
            p = p.next;
        }
        return sort(head,count);
    }
    
    private ListNode sort(ListNode head, int length){
        if(length == 1){
            return head;
        }
        int n = length/2;
        ListNode p = head;
        ListNode q = null;
        for(int i = 0; i < n - 1; i++){
            p = p.next;
        }
        q = p;
        p = p.next;
        q.next = null;
        return merge(sort(head,n),sort(p,length-n));
    }
    
    private ListNode merge(ListNode head1, ListNode head2){
        ListNode head = null;
        if(head1.val <= head2.val){
            head = head1;
            head1 = head1.next;
        }
        else {
            head = head2;
            head2 = head2.next;
        }
        ListNode p = head;
        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                p.next = head1;
                head1 = head1.next;
            }
            else {
                p.next = head2;
                head2 = head2.next;
            }
            p = p.next;
        }
        if(head1 == null){
            p.next = head2;
        }
        else if(head2 == null){
            p.next = head1;
        }
        return head;
    }
}