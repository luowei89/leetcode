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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<>();
        dfs(root, view, 1);
        return view;
    }
    
    public void dfs(TreeNode node, List<Integer> view, int depth) {
        if (node == null) {
            return;
        }
        if (depth > view.size()) {
            view.add(node.val);
        }
        dfs(node.right, view, depth + 1);
        dfs(node.left, view, depth + 1);
    }
}
