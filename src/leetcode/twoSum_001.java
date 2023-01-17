package leetcode;

import java.util.Arrays;

public class twoSum_001 {
    public int[] twoSum(int[] nums, int target) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);

        int start=0, end=nums.length-1;
        while(true) {
            if(copy[start] + copy[end] == target) {
                break;
            } else if(copy[start] + copy[end] > target) {
                end--;
            } else {
                start++;
            }
        }

        int[] ans = new int[]{-1, -1};
        for(int i=0; i<nums.length; i++) {


            System.out.println("i: " + i);

            if(ans[0] == -1 && nums[i] == copy[start]) {
                ans[0] = i;

            } else if(ans[1] == -1 && nums[i] == copy[end]) {
                ans[1] = i;
            }
        }

        return ans;
    }
}
