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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root ==null) {
            return null;
        }
        if(root.equals(p)) {
            return root;
        }
        if(root.equals(q)) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null){
            return root;
        } else {
            return left == null ? right : left;
        }
    }

    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     TreeNode node = root;
    //     Map<TreeNode, Map<TreeNode, Boolean>> cache = new HashMap<>();
    //     cache.put(p, new HashMap<>());
    //     cache.put(q, new HashMap<>());
    //     while (node != null) {
    //         if (inTree(node.left, p, cache) && inTree(node.left, q, cache)) {
    //             node = node.left;
    //         } else if (inTree(node.right, p, cache) && inTree(node.right, q, cache)) {
    //             node = node.right;
    //         } else {
    //             return node;
    //         }
    //     }
    //     return null;
    // }
    // 
    // public boolean inTree(TreeNode root, TreeNode node, Map<TreeNode, Map<TreeNode, Boolean>> cache) {
    //     if (cache.get(node).get(root) != null) {
    //         return cache.get(node).get(root);
    //     }
    //     if (root == null) {
    //         cache.get(node).put(root, false);
    //         return false;
    //     }
    //     if (root.equals(node)) {
    //         cache.get(node).put(root, true);
    //         return true;
    //     }
    //     boolean result = inTree(root.left, node, cache) || inTree(root.right, node, cache);
    //     cache.get(node).put(root, result);
    //     return result;
    // }
}
