package leetcode;

import java.util.Stack;

public class sumSubarrayMins_907 {
    public int sumSubarrayMins(int[] arr) {
        // O(n) time, O(n) space
        Stack<int[]> previousSmaller = new Stack<>();
        Stack<int[]> nextSmaller = new Stack<>();
        int[] leftToMin = new int[arr.length];
        int[] rightToMin = new int[arr.length];

        for(int i=0; i<arr.length; i++) {
            while(!previousSmaller.isEmpty() && previousSmaller.peek()[0] >= arr[i])
                previousSmaller.pop();
            leftToMin[i] = previousSmaller.isEmpty() ? i+1 : i-previousSmaller.peek()[1];
            previousSmaller.push(new int[]{arr[i], i});
        }

        for(int i=arr.length-1; i>=0; i--) {
            while(!nextSmaller.isEmpty() && nextSmaller.peek()[0] > arr[i])
                nextSmaller.pop();
            rightToMin[i] = nextSmaller.isEmpty() ? arr.length-i : nextSmaller.peek()[1]-i;
            nextSmaller.push(new int[]{arr[i], i});
        }

        int ans = 0, mod = 1000000007;
        for(int i=0; i<arr.length; i++) {
            ans = (ans + arr[i] * leftToMin[i] * rightToMin[i]) % mod;
        }
        return ans;
    }
}
