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
    
    private static int counter = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        counter = k;
        return kthSmallest(root);
    }
    
    private Integer kthSmallest(TreeNode node) {
        Integer left = null;
        Integer right = null;
        if (node.left != null) {
            left = kthSmallest(node.left);
        } 
        if (left != null) {
            return left;
        }
        counter--;
        if (counter == 0) {
            return node.val;
        }
        if (node.right != null) {
            right = kthSmallest(node.right);
        }
        return right;
    }
}
