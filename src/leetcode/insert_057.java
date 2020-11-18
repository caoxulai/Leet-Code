package leetcode;

public class insert_057 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] nonOverlapped = new int[intervals.length][2];
        int lo = newInterval[0], hi = newInterval[1];
        int j=0;
        for(int i=0; i<intervals.length; i++) {
            int[] interval = intervals[i];
            if(interval[1] < lo || interval[0]> hi){
                nonOverlapped[j++] = interval;
            }
            else{
                lo = Math.min(lo, interval[0]);
                hi = Math.max(hi, interval[1]);
            }
        }

        int[][] res = new int[j+1][2];
        int i=0;
        while(i < j){
            int[] interval = nonOverlapped[i];
            if(interval[1] < lo)
                res[i++] = interval;
            else
                break;
        }

        int[] tmp = new int[2];
        tmp[0] = lo; tmp[1] = hi;
        res[i++] = tmp;

        while(i <= j){
            int[] interval = nonOverlapped[i-1];
            res[i++] = interval;
        }

        return res;
    }
}
