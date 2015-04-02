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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
        if(root != null){
            ArrayList<Integer> path = new ArrayList<Integer>();
            pSum(root,sum,path,0,answer);
        }
        return answer;
    }
    private void pSum(TreeNode node, int sum, ArrayList<Integer> path,int value,ArrayList<ArrayList<Integer>> answer){
        value = value + node.val;
        path.add(new Integer(node.val));
        if(node.left == null && node.right == null){
            if(value == sum){
                answer.add(new ArrayList<Integer>(path));
            }
        }
        else{
            if(node.left != null){
                pSum(node.left,sum,path,value,answer);
            }
            if(node.right != null){
                pSum(node.right,sum,path,value,answer);
            }
        }
        path.remove(path.size()-1);
    }
}