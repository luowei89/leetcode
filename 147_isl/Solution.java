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
    public ListNode insertionSortList(ListNode head) {
        ListNode root = new ListNode(0);
        ListNode unSorted = head;
        while(unSorted != null){
            ListNode p = root;
            ListNode current = unSorted;
            unSorted = unSorted.next;
            while(p != null){
                if(p.next == null){
                    p.next = current;
                    current.next = null;
                    break;
                }
                if(current.val <= p.next.val){
                    ListNode temp = p.next;
                    p.next = current;
                    current.next = temp;
                    break;
                }
                p = p.next;
            }
        }
        return root.next;
    }
}