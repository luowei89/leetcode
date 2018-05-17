/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func kthSmallest(root *TreeNode, k int) int {
    val := 0
    n := 0
    var inorder func(*TreeNode)
    inorder = func(node *TreeNode) {
        if node == nil || n == k {
            return
        }
        inorder(node.Left)
        n++
        if n == k {
            val = node.Val
        }
        inorder(node.Right)
    }
    inorder(root)
    return val
}

