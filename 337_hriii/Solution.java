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
    
    private static Map<TreeNode, Integer> cacheWithNode;
    private static Map<TreeNode, Integer> cacheWithoutNode;

    public int rob(TreeNode root) {
        cacheWithNode = new HashMap<>();
        cacheWithoutNode = new HashMap<>();
        return Math.max(valueWithNode(root), valueWithoutNode(root));
    }
    
    private int valueWithNode(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (cacheWithNode.get(node) != null) {
            return cacheWithNode.get(node);
        }
        int value = node.val + valueWithoutNode(node.left) + valueWithoutNode(node.right);
        cacheWithNode.put(node, value);
        return value;
    }
    
    private int valueWithoutNode(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (cacheWithoutNode.get(node) != null) {
            return cacheWithoutNode.get(node);
        }
        int left = Math.max(valueWithNode(node.left), valueWithoutNode(node.left));
        int right = Math.max(valueWithNode(node.right), valueWithoutNode(node.right));
        int value = left + right;
        cacheWithoutNode.put(node, value);
        return value;
    }
}
