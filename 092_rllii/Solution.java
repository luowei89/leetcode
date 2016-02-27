/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 1 ≤ m ≤ n ≤ length of list.
        if (m == n) {
            return head;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode before = newHead;
        for (int i = 1; i < m; i++) {
            before = before.next;
        }
        ListNode start = before.next;
        ListNode p = start;
        ListNode q = start.next;
        for (int i = m; i < n; i++) {
            ListNode temp = q.next;
            q.next = p;
            p = q;
            q = temp;
        }
        before.next = p;
        start.next = q;
        return newHead.next;
    }
}
