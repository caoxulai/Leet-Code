package leetcode;

import java.util.ArrayList;
import java.util.List;

public class summaryRanges_228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if(nums.length ==0) return ans;

        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]);
        int start = 0;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] - nums[start] != i - start){
                if(start != i-1)
                    sb.append("->" + nums[i-1]);
                ans.add(sb.toString());
                sb.setLength(0);
                sb.append(nums[i]);
                start = i;
            }
        }
        if(start != nums.length - 1)
            sb.append("->" + nums[nums.length-1]);
        ans.add(sb.toString());

        return ans;
    }
}
