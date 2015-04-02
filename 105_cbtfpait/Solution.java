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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int size = preorder.length;
        return buildSubTree(preorder,inorder,0,0,size);
    }
    
    private TreeNode buildSubTree(int[] preorder, int[] inorder,int preIndex,int inIndex,int size){
        if(size == 0){
            return null;
        }
        int value = preorder[preIndex];
        int inI = inIndex;
        int newSize = 0;
        TreeNode node = new TreeNode(value);
        while(inorder[inI] != value){
            inI++;
            newSize++;
        }
        node.left = buildSubTree(preorder,inorder,preIndex+1,inIndex,newSize);
        node.right = buildSubTree(preorder,inorder,preIndex+newSize+1,inI+1,size-newSize-1);
        return node;
    }
}