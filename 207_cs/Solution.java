public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inLinks = new int[numCourses];
        Map<Integer, List<Integer>> outLinks = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            outLinks.put(i, new ArrayList<>());
        }
        for (int[] link : prerequisites) {
            int pre = link[0];
            int course = link[1];
            outLinks.get(pre).add(course);
            inLinks[course]++;
        }
        int used = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (inLinks[i] == 0) {
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            int course = stack.pop();
            used++;
            for (int next : outLinks.get(course)) {
                inLinks[next]--;
                if (inLinks[next] == 0) {
                    stack.push(next);
                }
            }
        }
        return used == numCourses;
    }
}
