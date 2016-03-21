public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (String[] ticket : tickets) {
            PriorityQueue<String> queue = graph.get(ticket[0]);
            if (queue == null) {
                queue = new PriorityQueue<>();
            }
            queue.add(ticket[1]);
            graph.put(ticket[0], queue);
        }
        
        String start = "JFK";
        List<String> itinerary = new ArrayList<>();
        return dfs(start, itinerary, graph, tickets.length + 1);
    }
    
    private List<String> dfs(String airport, List<String> itinerary, Map<String, PriorityQueue<String>> graph, int size) {
        itinerary.add(airport);
        if (itinerary.size() == size) {
            return itinerary;
        }
        PriorityQueue<String> queue = graph.get(airport);
        if (queue != null) {
            List<String> nexts = new ArrayList<>();
            while (!queue.isEmpty()) {
                nexts.add(queue.poll());
            }
            for (String next : nexts) {
                queue.add(next);
            }
            for (String next : nexts) {
                queue.remove(next);
                List<String> answer = dfs(next, itinerary, graph, size);
                if (answer != null) {
                    return answer;
                }
                queue.add(next);
            }
        }
        int index = itinerary.size()-1;
        itinerary.remove(index);
        return null;
    }
}
