package leetcode;

import java.util.Stack;

public class nextPermutation_031_2 {

    public static void main(String[] args) {
    }

    public void nextPermutation(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for(int i = nums.length - 1 ; i>=0; i--) {
            stack.push(nums[i]);
            if(i == 0 || nums[i] > nums[i-1]) {
                break;
            }
        }

        if(stack.size() == nums.length) {
            for(int i = nums.length - 1 ; i>=0; i--) {
                nums[i] = stack.pop();
            }
            return;
        }

        int prevIndex = nums.length - 1 - stack.size();
        int prev = nums[prevIndex];
        int index = nums.length - 1;
        while(!stack.isEmpty()) {
            int top = stack.pop();
            if(stack.size() == 0 || stack.peek() <= prev) {
                nums[prevIndex] = top;
                nums[index--] = prev;
                break;
            } else {
                nums[index--] = top;
            }
        }

        while(!stack.isEmpty()) {
            nums[index--] = stack.pop();
        }
    }
}
