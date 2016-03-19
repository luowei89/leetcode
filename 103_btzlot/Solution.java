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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        leftStack.push(root);
        while (!leftStack.isEmpty() || !rightStack.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            if (!leftStack.isEmpty()) {
                while (!leftStack.isEmpty()) {
                    TreeNode node = leftStack.pop();
                    list.add(node.val);
                    if (node.left != null) {
                        rightStack.push(node.left);
                    }
                    if (node.right != null) {
                        rightStack.push(node.right);
                    }
                }
            } else {
                while (!rightStack.isEmpty()) {
                    TreeNode node = rightStack.pop();
                    list.add(node.val);
                    if (node.right != null) {
                        leftStack.push(node.right);
                    }
                    if (node.left != null) {
                        leftStack.push(node.left);
                    }
                }
            }
            result.add(list);
        }
        return result;
    }
}
