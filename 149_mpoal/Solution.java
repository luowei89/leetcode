/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        int n = points.length;
        int max = 0;
        for(int i = 0; i < n - max; i++){
            int x1 = points[i].x;
            int y1 = points[i].y;
            int cMax = 1;
            HashMap<Double,Integer> map = new HashMap<Double,Integer>();
            for(int j = i + 1; j < n; j++){
                double xDist = points[j].x - x1;
                double yDist = points[j].y - y1;
                double s;
                if(xDist == 0 && yDist == 0){
                    cMax++;
                    continue;
                }
                if(xDist == 0){
                    s = Double.POSITIVE_INFINITY;
                }
                else if(yDist == 0){
                    s = 0;
                }
                else{
                    s = yDist/xDist;
                }
                if(map.containsKey(s)){
                    map.put(s,map.get(s)+1);
                }
                else{
                    map.put(s,1);
                }
            }
            if(!map.isEmpty()){
                cMax += Collections.max(map.values());
            }
            if(cMax > max){
                max = cMax;
            }
        }
        return max;
    }
}