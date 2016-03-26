/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    // O(n*lgk + N*lgk)
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new ListNodeComparator());
        for (ListNode n : lists) { // n *
            if (n != null) {
                minHeap.add(n);  // lgk
            }
        }
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (!minHeap.isEmpty()) { // N *
            ListNode next = minHeap.poll();
            p.next = next;
            p = p.next;
            if (next.next != null) {
                minHeap.add(next.next); //lgk
            }
        }
        return head.next;
    }
    
    public class ListNodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode n1, ListNode n2) {
            return n1.val - n2.val;
        }
    }
}
