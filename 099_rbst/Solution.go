/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func recoverTree(root *TreeNode)  {
    nodes := inorderTraversal(root)
    var node1, node2 *TreeNode
    for i,node := range nodes {
        if i + 1 >= len(nodes) {
            break
        }
        if node.Val > nodes[i+1].Val {
            if node1 == nil {
                node1 = node
                node2 = nodes[i+1]
            } else {
                node2 = nodes[i+1]
                break
            }
        }
    }
    swap(node1, node2)
}

func inorderTraversal(root *TreeNode) []*TreeNode {
    if root == nil {
        return nil
    }
    return append(append(inorderTraversal(root.Left), root) , inorderTraversal(root.Right)...)
}

func swap(node1, node2 *TreeNode) {
    temp := node1.Val
    node1.Val = node2.Val
    node2.Val = temp
}

