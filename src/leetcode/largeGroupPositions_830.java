package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class largeGroupPositions_830 {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        int count = 1;
        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i) == s.charAt(i-1))
                count++;
            else {
                if(count >= 3)
                    ans.add(Arrays.asList(i-count, i-1));
                count = 1;
            }
        }
        if(count >= 3)
            ans.add(Arrays.asList(s.length()-count, s.length()-1));

        return ans;
    }
}
