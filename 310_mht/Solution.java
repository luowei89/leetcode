public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        int unexplored = n;
        boolean[] explored = new boolean[n];

        Set<Integer> next = new HashSet<>();
        while (unexplored > 0) {
            next = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (!explored[i] && adjList.get(i).size() < 2) {
                    next.add(i);
                }
            }
            for (int i : next) {
                explored[i] = true;
                unexplored--;
                for (int j : adjList.get(i)) {
                    if (!explored[j]) {
                        adjList.get(j).remove((Integer)i);
                    }
                }
            }
        }
        result.addAll(next);
        return result;
    }
}
