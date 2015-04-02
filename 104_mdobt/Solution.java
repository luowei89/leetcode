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
    public int maxDepth(TreeNode root) {
       if(root == null){
           return 0;
       }
       return maxD(root);
    }
    
    private int maxD(TreeNode node){
        int lValue = 0;
        int rValue = 0;
        if(node.left == null && node.right == null){
            return 1;
        }
        if(node.left != null){
            lValue = 1 + maxD(node.left);
        }
        if(node.right != null){
            rValue = 1 + maxD(node.right);
        }
        return lValue > rValue ? lValue : rValue;
    }
}