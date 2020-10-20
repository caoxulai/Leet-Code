package leetcode;

import java.util.Arrays;

public class makeSquare_473 {
    private int[] sides = new int[4];

    public boolean makeSquare(int[] nums) {
        if(nums == null || nums.length == 0)    return false;
        int sum = getSum(nums);
        if(sum % 4 != 0)    return false;

        Arrays.sort(nums);

        return dfs(nums, nums.length - 1, sum/4);

    }

    private boolean dfs(int[] nums, int index, int target) {
        if(index == -1){
            return sides[0]==sides[1] && sides[1]==sides[2] && sides[2]==sides[3];
        }

        for(int i=0; i<4; i++) {
            if(sides[i] + nums[index] > target)
                continue;
            sides[i] += nums[index];
            if(dfs(nums, index - 1, target)) return true;
            sides[i] -= nums[index];
        }
        return false;
    }

    private int getSum(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        return sum;
    }
}
