/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(0);
        ListNode evenHead = new ListNode(0);
        ListNode odd = oddHead;
        ListNode even = evenHead;
        while(head != null) {
            odd.next = head;
            odd = odd.next;
            head = head.next;
            if (head != null) {
                even.next = head;
                even = even.next;
                head = head.next;
            }
        }
        odd.next = evenHead.next;
        even.next = null;
        return oddHead.next;
    }
}
