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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        String path = "";
        if(root != null) {
            path(root, result, path);
        }
        return result;
    }
    
    private void path(TreeNode node, List<String> result, String path) {
        // node is garunteed to be not null
        if(path.length() > 0) {
            path += "->";
        }
        path += node.val;
        if(node.left == null && node.right == null) {
            result.add(path.toString());
        } else {
            if (node.left != null) {
                path(node.left, result, path);
            }
            if (node.right != null) {
                path(node.right, result, path);
            }
        }
    }
}
