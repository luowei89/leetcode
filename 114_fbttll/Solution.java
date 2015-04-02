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
    public void flatten(TreeNode root) {
        if(root != null){
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);
            TreeNode head = new TreeNode(0);
            TreeNode node = null;
            TreeNode p = head;
            while(!stack.empty()){
                node = stack.pop();
                if(node.right != null){
                    stack.push(node.right);
                }
                if(node.left != null){
                    stack.push(node.left);
                }
                p.right = node;
                p = p.right;
                p.left = null;
            }
            root = head.right;
        }
    }
}