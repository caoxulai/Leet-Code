package leetcode;

import java.util.ArrayList;
import java.util.List;

public class pancakeSort_969 {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ans = new ArrayList();
        for(int i=arr.length; i>0; i--){
            int index = find(arr, i);
            if(index == 0){
                ans.add(i);
                reverse(arr, 0, i-1);
            }else if (index != i-1) {
                ans.add(index+1);
                reverse(arr, 0, index);
                ans.add(i);
                reverse(arr, 0, i-1);
            }
        }
        return ans;
    }

    private int find(int[] nums, int target){
        for(int i=0; i<nums.length; i++){
            if(nums[i] == target)
                return i;
        }
        return -1;
    }


    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private void reverse(int[] nums, int i, int j){
        while(i<j){
            int t = nums[i];
            nums[i++] = nums[j];
            nums[j--] = t;
        }
    }
}
