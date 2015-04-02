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
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return symmetric(root.left,root.right);
    }
    private boolean symmetric(TreeNode p,TreeNode q){
        if(p == null && q == null){
            return true;
        }
        else if(p != null && q != null){
            return p.val == q.val && symmetric(p.left,q.right) && symmetric(p.right, q.left);
        }
        else{
            return false;
        }
    }
}