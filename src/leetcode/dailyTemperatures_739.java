package leetcode;

import java.util.Stack;

public class dailyTemperatures_739 {
    public int[] dailyTemperatures(int[] T) {
        Stack<int[]> stack = new Stack<>();
        int[] ans = new int[T.length];

        for(int i=0; i<T.length; i++) {
            while(!stack.isEmpty() && stack.peek()[0] < T[i]) {
                int[] pair = stack.pop();
                ans[pair[1]] = i - pair[1];
            }
            stack.push(new int[]{T[i], i});
        }
        return ans;
    }
}
