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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode p = head;
        ListNode q = head.next;
        while(q != null){
            if(p.val == q.val){
                p.next = q.next;
            }
            else{
                p = p.next;
            }
            q = q.next;
        }
        return head;
    }
}