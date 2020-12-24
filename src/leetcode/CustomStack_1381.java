package leetcode;

public class CustomStack_1381 {
    class CustomStack {
        private int maxSize;
        private Stack<Integer> stack;

        public CustomStack(int maxSize) {
            this.maxSize = maxSize;
            stack = new Stack<>();
        }

        public void push(int x) {
            if(stack.size() < maxSize)
                stack.push(x);
        }

        public int pop() {
            return stack.isEmpty() ? -1 : stack.pop();
        }

        public void increment(int k, int val) {
            Stack<Integer> buffer = new Stack<>();

            while(!stack.isEmpty()) {
                buffer.push(stack.pop());
            }

            for(int i=0; i<k && !buffer.isEmpty(); i++){
                stack.push(buffer.pop() + val);
            }
            while(!buffer.isEmpty()) {
                stack.push(buffer.pop());
            }
        }
    }

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
}
