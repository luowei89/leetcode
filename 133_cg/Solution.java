/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null){
            return null;
        }
        HashMap<UndirectedGraphNode,UndirectedGraphNode> explored;
        explored = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        explored.put(node,newNode);
        queue.add(node);
        while(!queue.isEmpty()){
            UndirectedGraphNode current = queue.poll();
            UndirectedGraphNode copy = explored.get(current);
            for(UndirectedGraphNode n : current.neighbors){
                if(explored.containsKey(n)){
                    copy.neighbors.add(explored.get(n));
                }
                else{
                    UndirectedGraphNode nn = new UndirectedGraphNode(n.label);
                    copy.neighbors.add(nn);
                    explored.put(n,nn);
                    queue.add(n);
                }
            }
        }
        return newNode;
    }
}