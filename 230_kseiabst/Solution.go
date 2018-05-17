/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func kthSmallest(root *TreeNode, k int) int {
    return inorder(root)[k - 1]
}

func inorder(root *TreeNode) []int {
    if root == nil {
        return nil
    }
    return append(append(inorder(root.Left), root.Val) , inorder(root.Right)...)
}

