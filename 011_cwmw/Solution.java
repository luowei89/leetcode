public class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int maxArea = 0;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            int area = 0;
            if (height[i] < height[j]) {
                area = height[i] * (j-i);
                i++;
            } else {
                area = height[j] * (j-i);
                j--;
            }
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }
}
