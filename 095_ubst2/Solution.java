/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        HashMap<Integer,ArrayList<TreeNode>> map;
        map = new HashMap<Integer,ArrayList<TreeNode>>();
        ArrayList<TreeNode> al0 = new ArrayList<TreeNode>();
        ArrayList<TreeNode> al1 = new ArrayList<TreeNode>();
        al0.add(null);
        al1.add(new TreeNode(1));
        map.put(0,al0);
        map.put(1,al1);
        for(int i = 2; i < n+1; i++){
            ArrayList<TreeNode> ali = new ArrayList<TreeNode>();
            for(int j = 1; j < i+1; j++){
                ArrayList<TreeNode> left = map.get(j-1);
                ArrayList<TreeNode> right = map.get(i-j);
                for(TreeNode l : left){
                    for(TreeNode r : right){
                        TreeNode root = new TreeNode(j);
                        root.left = copy(0,l);
                        root.right = copy(j,r);                            
                        ali.add(root);
                    }
                }
            }
            map.put(i,ali);
        }
        return map.get(n);
    }
    
    private TreeNode copy(int base,TreeNode node){
        if(node == null){
            return null;
        }
        TreeNode newNode = new TreeNode(node.val + base);
        if(node.left != null){
            newNode.left = copy(base,node.left);
        }
        if(node.right != null){
            newNode.right = copy(base,node.right);
        }
        return newNode;
    }
}