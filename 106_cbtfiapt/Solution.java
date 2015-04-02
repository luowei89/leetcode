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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int size = inorder.length;
        return buildSubTree(inorder,postorder,0,size-1,size);
    }
    
    private TreeNode buildSubTree(int[] inorder, int[] postorder,int inIndex,int postIndex,int size){
        if(size == 0){
            return null;
        }
        int value = postorder[postIndex];
        int inI = inIndex;
        int newSize = 0;
        TreeNode node = new TreeNode(value);
        while(inorder[inI] != value){
            inI++;
            newSize++;
        }
        node.left = buildSubTree(inorder,postorder,inIndex,postIndex-size+newSize,newSize);
        node.right = buildSubTree(inorder,postorder,inI+1,postIndex-1,size-newSize-1);
        return node;
    }
}