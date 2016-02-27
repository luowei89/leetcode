/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }
    
    private TreeNode buildTree(ListNode start, ListNode end) {
        if (start == null) {
            return null;
        }
        if (start == end) {
            return null;
        }
        if (start.next == end) {
            return new TreeNode(start.val);
        }
        ListNode p = start.next;
        ListNode q = start;
        while (p != end && p.next != end) {
            p = p.next.next;
            q = q.next;
        }
        TreeNode node = new TreeNode(q.val);
        node.left = buildTree(start, q); 
        node.right = buildTree(q.next, end); 
        return node;
    }
}
