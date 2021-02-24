package leetcode;

import java.util.PriorityQueue;

public class carFleet_853 {
    public int carFleet(int target, int[] position, int[] speed) {
        PriorityQueue<int[]> posToSpeedMap = new PriorityQueue<>((a, b)->Integer.compare(b[0], a[0]));
        for(int i=0; i<position.length; i++){
            posToSpeedMap.add(new int[]{position[i], speed[i]});
        }

        double[] time = new double[position.length];
        for(int i=0; i<time.length; i++) {
            int[] posToSpeed = posToSpeedMap.poll();
            time[i] = (double) (target - posToSpeed[0]) / posToSpeed[1];
        }

        int fleets = 0;
        double maxTime = -1;
        for(int i=0; i< time.length; i++) {
            if(time[i] > maxTime) {
                maxTime = time[i];
                fleets++;
            }
        }

        return fleets;
    }
}
