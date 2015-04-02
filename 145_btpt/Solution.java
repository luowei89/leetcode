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
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> answer = new ArrayList<Integer>();
        ArrayList<TreeNode> explored = new ArrayList<TreeNode>();
        if(root != null){
            stack.push(root);
        }
        while(!stack.empty()){
            TreeNode node = stack.peek();
            if(node.right != null && !explored.contains(node.right)){
                stack.push(node.right);
            }
            if(node.left != null && !explored.contains(node.left)){
                stack.push(node.left);
            }
            if(node.equals(stack.peek())){
                stack.pop();
                answer.add(node.val);
                explored.add(node);
            }
        }
        return answer;
    }
}