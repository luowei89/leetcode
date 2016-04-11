/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode r = head;
        int carry  = 0;
        while (p != null || q != null) {
            int vp = p == null ? 0 : p.val;
            int vq = q == null ? 0 : q.val;
            int sum = vp + vq + carry;
            r.next = new ListNode(sum % 10);
            r = r . next;
            carry = sum / 10;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            r.next = new ListNode(carry);
        }
        return head.next;
    }
}
