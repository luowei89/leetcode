/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        while(p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        // p1 is before the start of 2nd half of list
        ListNode head2 = reverseList(p1.next);
        while (head2 != null) {
            if (head.val != head2.val) {
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }
    
    private ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p1 = null;
        ListNode p2 = head;
        ListNode tmp;
        while (p2 != null) {
            tmp = p2.next;
            p2.next= p1;
            p1 = p2;
            p2 = tmp;
        }
        return p1;
    }
}
