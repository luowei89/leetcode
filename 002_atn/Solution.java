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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int addOne = 0;
        ListNode head = new ListNode(0);
        ListNode p = head;
        while(l1 != null && l2 != null){
            int num =  l1.val+l2.val+addOne;
            addOne = num/10;
            ListNode node = new ListNode(num%10);
            p.next = node;
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int num =  l1.val+addOne;
            addOne = num/10;
            ListNode node = new ListNode(num%10);
            p.next = node;
            p = p.next;
            l1 = l1.next;
        }
        while(l2 != null){
            int num =  l2.val+addOne;
            addOne = num/10;
            ListNode node = new ListNode(num%10);
            p.next = node;
            p = p.next;
            l2 = l2.next;
        }
        if(addOne == 1){
            ListNode node = new ListNode(1);
            p.next = node;
        }
        return head.next;
    }
}