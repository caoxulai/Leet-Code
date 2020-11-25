package leetcode;

import java.util.Arrays;

public class findPairs_532 {
    public int findPairs(int[] nums, int k) {
        // O(nlogn) time, O(1) space
        int count = 0;
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) {
            if(i>0 && nums[i]==nums[i-1])
                continue;
            // binarySearch(int[] a, int fromIndex, int toIndex, int key)
            // if not found, returns (-(insertion point) - 1)
            int index = Arrays.binarySearch(nums, i+1, nums.length, nums[i]+k);
            if(index > 0)
                count++;
        }
        return count;
    }
}
