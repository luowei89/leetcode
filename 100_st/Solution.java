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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean eq = false;
        if(p == null && q == null){
            return true;
        } 
        else if(p == null || q == null){
            return false;
        }
        else{
            eq = p.val == q.val;
        }
        if(!eq){
            return false;
        }
        boolean left = isSameTree(p.left,q.left);
        boolean right = isSameTree(p.right,q.right);
        return left && right;
    }
}