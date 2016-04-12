public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[] heights = new int[n];
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            heights[i] = matrix[0][i] - '0';
        }
        maxArea = Math.max(largestRectangleArea(heights), maxArea);
        for (int j = 1; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (matrix[j][i] == '1') {
                    heights[i] += 1;
                } else {
                    heights[i] = 0;
                }
            }
            maxArea = Math.max(largestRectangleArea(heights), maxArea);
        }
        return maxArea;
    }
    
    private int largestRectangleArea(int[] heights) {
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
}
