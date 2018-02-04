/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Bryce
 */
public class mergeIntervals_056 {
    /** Definition for an interval.*/
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    
    class Solution {
        public List<Interval> merge(List<Interval> intervals) {
            Collections.sort(intervals, (a, b) -> a.start-b.start);
            if(intervals == null || intervals.isEmpty())   return intervals;
            List<Interval> res = new ArrayList<>();
            Interval pre = null;
            for(Interval i: intervals){
                if(pre == null){
                    pre = i;
                }else{
                    if(pre.end >= i.start)
                        pre.end = Math.max(pre.end, i.end);
                    else{
                        res.add(pre);
                        pre = i;
                    }
                }
            }
            res.add(pre);
            return res;
        }
    }
}
