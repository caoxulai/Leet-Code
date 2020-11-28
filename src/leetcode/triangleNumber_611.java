package leetcode;

import java.util.Arrays;

public class triangleNumber_611 {
    public int triangleNumber(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++) {
            for(int j=i+1; j<nums.length-1; j++) {
                // binarySearch(int[] a, int fromIndex, int toIndex, int key)
                int third = binarySearch(nums, j, nums.length-1, nums[i] + nums[j] - 1);
                ans += third - j;
            }
        }
        return ans;
    }

    private int binarySearch(int[] nums, int lo, int hi, int target) {
        while(lo < hi) {
            int mid = lo + (hi-lo+1)/2;
            if(nums[mid] == target){
                while(mid < nums.length-1 && nums[mid] == nums[mid+1]){
                    mid++;
                }
                return mid;
            }else if(nums[mid] > target){
                hi = mid - 1;
            }else
                lo = mid;
        }
        return hi;
    }
}
