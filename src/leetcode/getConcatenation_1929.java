package leetcode;

public class getConcatenation_1929 {
    public int[] getConcatenation(int[] nums) {
        int len = nums.length;
        int[] ans = new int[2*len];
        for(int i=0; i<len; i++) {
            ans[i] = nums[i];
            ans[len + i] = nums[i];
        }
        return ans;
    }
}
