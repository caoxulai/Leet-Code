package leetcode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author Bryce
 */
public class mergeIntervals_056_2 {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        for(int i=0; i<intervals.length; i++) {
            queue.add(new int[]{intervals[i][0], intervals[i][1]});
        }

        Queue<int[]> result = new LinkedList<>();
        while(!queue.isEmpty()) {
            if(queue.size() == 1) {
                result.add(queue.poll());
                continue;
            }

            int[] first = queue.poll();
            int[] second = queue.poll();

            if(first[1] < second[0]) {
                result.add(first);
                queue.add(second);
            } else {
                queue.add(new int[]{first[0], Math.max(first[1], second[1])});
            }
        }

        return toArray(result);
    }

    private int[][] toArray(Queue<int[]> result) {
        int[][] ans = new int[result.size()][2];
        int i = 0;
        while(!result.isEmpty()) {
            int[] current = result.poll();
            ans[i][0] = current[0];
            ans[i++][1] = current[1];
        }
        return ans;
    }
}
