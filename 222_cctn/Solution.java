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
    public int countNodes(TreeNode root) {
        int height = height(root);
        return countNodes(root, height);
    }
    
    public int height(TreeNode node) {
        TreeNode p = node;
        int height = 0;
        while (p != null) {
            height++;
            p = p.left;
        }
        return height;
    }
    
    public int countNodes(TreeNode node, int height) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height - 1;
        int rightHeight = height(node.right);
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) + countNodes(node.right, rightHeight);
        } else {
            return (1 << rightHeight) + countNodes(node.left, leftHeight);
        }
    }
    // recurcive TLE
    // public int countNodes(TreeNode root) {
    //     if (root == null) {
    //         return 0;
    //     }
    //     return countNodes(root.left) + countNodes(root.right) + 1;
    // }
}
