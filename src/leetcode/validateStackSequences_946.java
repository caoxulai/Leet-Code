package leetcode;

public class validateStackSequences_946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int y = 0;
        for(int num : pushed) {
            stack.push(num);
            while(!stack.isEmpty() && stack.peek() == popped[y]) {
                stack.pop();
                y++;
            }
        }
        return stack.isEmpty();
    }
}
