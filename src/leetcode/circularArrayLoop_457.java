package leetcode;

public class circularArrayLoop_457 {
    public boolean circularArrayLoop(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0)
                continue;
            int slow = i, fast = getNextIndex(i, nums);
            while(nums[i] * nums[fast] > 0 && nums[i] * nums[getNextIndex(fast, nums)] > 0 ) {
                if(slow == fast){
                    if(slow == getNextIndex(slow, nums))
                        // cycle's length == 1
                        break;
                    else
                        return true;
                }
                slow = getNextIndex(slow, nums);
                fast = getNextIndex(getNextIndex(fast, nums), nums);
            }

            slow = i;
            int val = nums[i];
            while(val * nums[slow] > 0) {
                int next = getNextIndex(slow, nums);
                nums[slow] = 0;
                slow = next;
            }
        }
        return false;
    }

    private int getNextIndex(int i, int[] nums) {
        int len = nums.length;
        return (len + (i+nums[i]) % len) % len;
    }
}
