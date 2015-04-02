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
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Integer> depths = new LinkedList<Integer>();
        queue.add(root);
        depths.add(1);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            int depth = depths.poll();
            if(node.left == null && node.right == null){
                return depth;
            }
            if(node.left != null){
                queue.add(node.left);
                depths.add(depth+1);
            }
            if(node.right != null){
                queue.add(node.right);
                depths.add(depth+1);
            }
        }
        return 0;        
    }
}