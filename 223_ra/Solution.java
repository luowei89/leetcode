public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int overlayArea = overlayArea(A, B, C, D, E, F, G, H);
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);
        return area1 + area2 - overlayArea;
    }
    
    private int overlayArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int overlayX = overlay(A, C, E, G);
        int overlayY = overlay(B, D, F, H);
        return overlayX * overlayY;
    }

    private int overlay(int A, int C, int E, int G) {
        if (C < E || G < A) {
            return 0;
        }
        int ac = C - A;
        int eg = G - E;
        int left = A < E ? A : E;
        int right = C > G ? C : G;
        return ac + eg - (right - left);
    }
}
