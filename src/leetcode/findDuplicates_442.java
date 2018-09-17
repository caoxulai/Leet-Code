package leetcode;

import java.util.ArrayList;
import java.util.List;

public class findDuplicates_442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            int value = Math.abs(nums[i]);
            nums[value-1] = -nums[value-1];
            if(nums[value-1] > 0)  res.add(value);
        }
        return res;
    }
}