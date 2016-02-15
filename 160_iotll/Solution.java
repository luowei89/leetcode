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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lenA = len(headA);
        int lenB = len(headB);
        if(lenA > lenB) {
            int diff = lenA - lenB;
            while(diff > 0) {
                diff--;
                headA = headA.next;
            }
        }
        if(lenA < lenB) {
            int diff = lenB - lenA;
            while(diff > 0) {
                diff--;
                headB = headB.next;
            }
        }
        while(headA != null) {
            if(headA.equals(headB)) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
        
    }
    
    private int len(ListNode head) {
        int len = 0;
        ListNode n = head;
        while(n != null) {
            len++;
            n = n.next;
        }
        return len;
    }
}
