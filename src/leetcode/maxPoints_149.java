/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.HashMap;

/**
 *
 * @author I852047
 */
public class maxPoints_149 {
    
    class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }
    
    class Solution {
        // 44.94%
        public int maxPoints(Point[] points) {
            int max = 0;
            for(int i=0; i<points.length; i++){
                int same = 1;
                HashMap<String, Integer> slopeCount = new HashMap<>();
                int x1 = points[i].x;
                int y1 = points[i].y;
                for(int j=i+1; j<points.length; j++){
                    int x = points[j].x - x1;
                    int y = points[j].y - y1;
                    // same coordinate, record the count and skip the subsequent steps
                    if(x==0 && y==0){
                        same++;
                        continue;
                    }
                    // get the greatest common divider, and unify x & y to get the slope string.
                    int gcd = gcd(x, y);
                    x /= gcd;
                    y /= gcd;
                    StringBuilder sb = new StringBuilder();
                    sb.append(x).append("#").append(y);
                    String slope = sb.toString();
                    
                    slopeCount.put(slope, slopeCount.getOrDefault(slope, 0) + 1);
                }
                int localMax = 0;
                for(int count: slopeCount.values()){
                    localMax = Math.max(localMax, count);
                }
                
                max = Math.max(max, localMax + same);
            }
            return max;
        }
        
        private int gcd(int a, int b){
            if(a == 0)  return b;
            return gcd(b%a, a);
        }
    }
}
