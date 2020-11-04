package leetcode;

public class rob_198 {
    public int rob(int[] nums) {
        if(nums == null || nums.length ==0) return 0;
        int a=0, b=0;
        for(int num : nums) {
            int temp = Math.max(a, b + num);
            b = a;
            a = temp;
        }
        return a;
    }
}
