/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author I852047
 */
public class mySqrt_069 {
    // mid is rounded to the upper mid point
    class Solution {
    public int mySqrt(int x) {
        if(x == 0)  return 0;
        int lo=1, hi=Integer.MAX_VALUE;
        while(lo < hi){
            int mid = (int)((lo + ((hi - lo) / 2.0) + 0.5));
            if(mid <= x/mid)
                lo = mid;
            else
                hi = mid-1;
        }
        return lo;
    }
}
}
