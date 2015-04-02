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
        ListNode s = new ListNode(0);
        s.next = head;
        head = s;
        ListNode p = head.next;
        ListNode q = head.next.next;
        ListNode r = head;
        boolean duplicate = false;
        while(q != null){
            if(p.val == q.val){
                duplicate = true;
            }
            else{
                if(duplicate){
                    duplicate = false;
                }
                else{
                    r.next = p;
                    r = r.next;
                }
                p = q;
            }
            q = q.next;
        }
        if(duplicate){
            r.next = null;
        }
        else{
            r.next = p;
        }
        return head.next;
    }
}