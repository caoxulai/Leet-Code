package leetcode;

import java.util.ArrayList;
import java.util.List;

public class buildArray_1441 {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int j = 0;
        for(int i=1; i<=n; i++) {
            ans.add("Push");
            if(target[j] != i)
                ans.add("Pop");
            else if(++j == target.length)
                break;
        }
        return ans;
    }
}
