/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode p = newHead;
        ListNode q =head;
        while (q != null && q.next != null) {
            ListNode n1 = q;
            ListNode n2 = q.next;
            q = n2.next;
            p.next = n2;
            n2.next = n1;
            n1.next = q;
            p = n1;
        }
        return newHead.next;
    }
}
