/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int left_depth = depth(root.left);
        int right_depth = depth(root.right);
        if(left_depth - right_depth > 1 || right_depth - left_depth > 1){
           return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    private int depth(TreeNode node){
        if(node == null){
            return 0;
        }
        int left_depth = depth(node.left);
        int right_depth = depth(node.right);
        int depth = left_depth > right_depth?left_depth:right_depth;
        return depth + 1;
    }
}