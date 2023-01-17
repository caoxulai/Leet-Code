package leetcode;

public class maxSubArray_053 {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int num : nums) {
            sum += num;
            max = Math.max(sum, max);
            sum = Math.max(0, sum);
        }
        return max;
    }
}
