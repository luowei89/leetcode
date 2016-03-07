public class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            int h = i == heights.length ? 0 : heights[i];
            if (stack.isEmpty() || h > heights[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && h <= heights[stack.peek()]) {
                    int j = stack.pop();
                    int area = (stack.isEmpty() ? i : i-1-stack.peek()) * heights[j];  
                    maxArea = Math.max(maxArea, area);  
                }
                stack.push(i);
            }
        }
        return maxArea;
    }
    
    // Brute Force: O(n^2)
}
