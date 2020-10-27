package leetcode;

public class PredictTheWinner_486 {
    // O(n^2) time, O(n^2) space
    // memory to store the delta when selecting from index i to j of the nums
    private Integer[][] memo;

    public boolean PredictTheWinner(int[] nums) {
        memo = new Integer[nums.length][nums.length];
        return winner(nums, 0, nums.length-1) >= 0;
    }

    private int winner(int[] nums, int start, int end) {
        if(memo[start][end] != null)
            return memo[start][end];
        if(start == end)
            return nums[start];

        // case 1: take the starting num
        int a = nums[start] - winner(nums, start+1, end);
        // case 2: take the ending num
        int b = nums[end] - winner(nums, start, end-1);

        memo[start][end] = Math.max(a,b);
        return memo[start][end];
    }
}
