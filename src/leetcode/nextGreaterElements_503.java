package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class nextGreaterElements_503 {
    public int[] nextGreaterElements(int[] nums) {
        // O(n) time, O(n) space
        // map from x to next greater element of x
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }

        // another round for numbers whose next greater element is at smaller index
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
        }

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            ans[i] = map.getOrDefault(nums[i], -1);
        return ans;
    }
}
