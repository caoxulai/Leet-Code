package leetcode;

public class findPoisonedDuration_495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length == 0)  return 0;
        int ans = duration;
        int prev = timeSeries[0];
        for(int time : timeSeries) {
            ans += Math.min(duration, time - prev);
            prev = time;
        }
        return ans;
    }
}
