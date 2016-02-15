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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        traverse(root, result, 0);
        return result;
    }
    
    public void traverse(TreeNode node, List<List<Integer>> result, int depth) {
        if (node != null) {
            List<Integer> level;
            //depth should be increasing
            if(result.size() < depth + 1) {
                level = new ArrayList<>();
                result.add(level);
            } else {
                level = result.get(depth);
            }
            level.add(node.val);
            traverse(node.left, result, depth + 1);
            traverse(node.right, result, depth + 1);
        }
    }
}
