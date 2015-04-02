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
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        return sum(root,0);
    }
    
    private int sum(TreeNode node, int value){
        value = value*10 + node.val;
        if(node.left == null && node.right == null){
            return value;
        }
        int leftAnswer = 0;
        int rightAnswer = 0;
        if(node.left != null){
            leftAnswer = sum(node.left,value);
        }
        if(node.right != null){
            rightAnswer = sum(node.right,value);
        }
        return leftAnswer + rightAnswer; 
    }
}