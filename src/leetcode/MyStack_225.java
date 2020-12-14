package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack_225 {
    class MyStack {

        private Queue<Integer> queue;

        /** Initialize your data structure here. */
        public MyStack() {
            queue = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            if(!queue.isEmpty())
                moveFirstToLast();

            queue.offer(x);
            for(int i=0; i<queue.size()-1; i++)
                moveFirstToLast();
        }

        private void moveFirstToLast() {
            int tmp = queue.poll();
            queue.offer(tmp);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            int ans = queue.poll();
            for(int i=0; i<queue.size()-1; i++)
                moveFirstToLast();
            return ans;
        }

        /** Get the top element. */
        public int top() {
            return queue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
