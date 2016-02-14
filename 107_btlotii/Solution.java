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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Map<Integer, List<Integer>> levelMap = new HashMap<>();
        int depth = reaverseTree(root, levelMap, 0);
        List<List<Integer>> result = new ArrayList<>();
        for (;depth >= 0; depth--) {
            result.add(levelMap.get(depth));
        }
        return result;
    }
    
    private int reaverseTree(TreeNode root, Map<Integer, List<Integer>> levelMap, int depth) {
        if (root == null) {
            return depth - 1;
        }
        List<Integer> currentList = levelMap.get(depth);
        if (currentList == null) {
            currentList = new ArrayList<>();
        }
        int leftDepth = reaverseTree(root.left, levelMap, depth+1);
        int rightDepth = reaverseTree(root.right, levelMap, depth+1);
        currentList.add(root.val);
        levelMap.put(depth, currentList);
        return leftDepth > rightDepth ? leftDepth : rightDepth;
    }
}
