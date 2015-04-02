/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head != null && head.next != null){
            ListNode p1 = head;
            ListNode p2 = head.next;
            while(p2!= null && p2.next != null){
                p1 = p1.next;
                p2 = p2.next.next;
            }
            ListNode mid = p1.next;
            p1.next = null;
            mid = reverse(mid,mid.next);
            merge(head,mid);
        }
    }

    private ListNode reverse(ListNode node,ListNode next){
        if(next == null){
            return node;
        }
        ListNode head = reverse(node.next,next.next);
        next.next = node;
        node.next = null;
        return head;
    }

    private void merge(ListNode head1,ListNode head2){
        ListNode p1 = head1;
        ListNode p2 = head2;
        while(p2 != null){
            ListNode next = p1.next;
            ListNode next2 = p2.next;
            p1.next = p2;
            p2.next = next;
            p1 = next;
            p2 = next2;
        }
    }
}