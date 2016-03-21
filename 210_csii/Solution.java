public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inLinks = new int[numCourses];
        int[] result = new int[numCourses];
        int index = 0;
        Map<Integer, List<Integer>> outLinks = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            outLinks.put(i, new ArrayList<>());
        }
        for (int[] link : prerequisites) {
            int course = link[0];
            int pre = link[1];
            outLinks.get(pre).add(course);
            inLinks[course]++;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (inLinks[i] == 0) {
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            int course = stack.pop();
            result[index++] = course;
            for (int next : outLinks.get(course)) {
                inLinks[next]--;
                if (inLinks[next] == 0) {
                    stack.push(next);
                }
            }
        }
        int[] empty = {};
        return index == numCourses ? result : empty;
    }
}
