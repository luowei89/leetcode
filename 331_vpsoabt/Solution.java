public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int unvisitedNodes = nodes.length;
        int leafCount = 0;
        Queue<Integer> nodeIndexes = new LinkedList<>();
        nodeIndexes.add(1);
        while (!nodeIndexes.isEmpty()) {
            int index = nodeIndexes.poll();
            if (index > nodes.length) {
                return false;
            }
            if ("#".equals(nodes[index-1])) {
                leafCount++;
            } else {
                int left = (index - leafCount) * 2;
                nodeIndexes.add(left);
                nodeIndexes.add(left + 1); // right
            }
            unvisitedNodes--;
        }
        return unvisitedNodes == 0;
    }
}
