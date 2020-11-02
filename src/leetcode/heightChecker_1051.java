package leetcode;

import java.util.Arrays;

public class heightChecker_1051 {
    // O(n*logn) time, O(n) space
    public int heightChecker(int[] heights) {
        int[] sorted = heights.clone();
        Arrays.sort(sorted);
        int count = 0;
        for(int i=0; i<heights.length; i++) {
            if(heights[i] != sorted[i])
                count++;
        }
        return count;
    }
}
