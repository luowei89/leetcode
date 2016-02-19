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
    
    private static int max;
    
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxHalfPathSum(root);
        return max;
    }
    
    private int maxHalfPathSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxHalfPathSum(node.left);
        int right = maxHalfPathSum(node.right);
        int pathSum = node.val;
        pathSum += left > 0 ? left : 0;
        pathSum += right > 0 ? right : 0;
        if (pathSum > max) {
            max = pathSum;
        }
        if (left < 0 && right < 0) {
            return node.val;
        } else {
            return left > right ? left + node.val : right + node.val;
        }
    }
}
