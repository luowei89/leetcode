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
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        return validBST(root,Integer.MAX_VALUE,Integer.MIN_VALUE);
    }
    
    private boolean validBST(TreeNode node,int upper,int lower){
        if(node.val >= upper || node.val <= lower){
            return false;
        }
        boolean left = true;
        boolean right = true;
        if(node.left != null){
            left = validBST(node.left,node.val,lower);
        }
        if(node.right != null){
            right = validBST(node.right,upper,node.val);
        }
        return left && right;
    }
}