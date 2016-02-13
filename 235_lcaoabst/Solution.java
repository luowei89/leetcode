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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        if(left != null) {
            return left;
        }
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(right != null) {
            return right;
        }
        if (inTree(root, p) && inTree(root, q)) {
            return root;
        } else {
            return null;
        }
    }
    
    public boolean inTree(TreeNode root, TreeNode n) {
        if(root == null || n == null){
            return false;
        }
        if(root.equals(n)) {
            return true;
        }
        return inTree(root.left, n) || inTree(root.right, n);
    }
}
