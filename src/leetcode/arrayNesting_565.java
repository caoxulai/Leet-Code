package leetcode;

public class arrayNesting_565 {
    public int arrayNesting(int[] nums) {
        int max = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == -1)
                continue;
            int next = nums[i];
            int count = 1;
            while(i != next) {
                // System.out.println("next: " + next);
                next = nums[next];
                count++;
            }
            max = Math.max(max, count);

            next = nums[i];
            while(i != next) {
                int tmp = nums[next];
                nums[next] = -1;
                next = tmp;
            }
            nums[i] = -1;
        }
        return max;
    }
}
