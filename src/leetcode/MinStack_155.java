/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.Stack;

/**
 *
 * @author Bryce
 */
public class MinStack_155 {
    class MinStack {
        long min;
        Stack<Long> stack;
        
        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            min = 0L;
        }
        
        public void push(int x) {
            if(stack.isEmpty()){
                min = x;
            }
            stack.push(x-min);
            if(x<min){
                min = x;
            }
        }
        
        public void pop() {
            long pop = stack.pop();
            if(pop<0){
                min = min-pop;
            }
        }
        
        public int top() {
            long top = stack.peek();
            if(top>0)   return (int) (min+top);
            else return (int) min;
        }
        
        public int getMin() {
            return (int) min;
        }
    }
    
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
}
