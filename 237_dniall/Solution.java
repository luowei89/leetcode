/**
 *Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void deleteNode(ListNode node) {
        ListNode n = node.next;
        if (n != null) {
            node.val = n.val;
            node.next = n.next;
        }
    }
}
