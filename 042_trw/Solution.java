public class Solution {
    public int trap(int[] height) {
        int highest = 0;
        // find the highest
        for (int i = 0; i < height.length; i++) {
            if (height[i] > height[highest]) {
                highest = i;
            }
        }
        int water = 0;
        int left = 0;
        // left of highest
        for (int i = 0; i < highest; i++) {
            if (height[i] >= height[left]) {
                left = i;
            } else {
                water += height[left] - height[i];
            }
        }
        // right of highest
        int right = height.length - 1;
        for (int i = height.length - 1; i > highest; i--) {
            if (height[i] >= height[right]) {
                right = i;
            } else {
                water += height[right] - height[i];
            }
        }
        return water;
    }
}
