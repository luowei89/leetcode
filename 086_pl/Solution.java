/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallerHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);
        ListNode p = head;
        ListNode s = smallerHead;
        ListNode g = greaterHead;
        while (p != null) {
            if (p.val < x) {
                s.next = p;
                s = s.next;
            } else {
                g.next = p;
                g = g.next;
            }
            p = p.next;
        }
        s.next = greaterHead.next;
        g.next = null;
        return smallerHead.next;
    }
}
