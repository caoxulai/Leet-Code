/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.Stack;

/**
 *
 * @author I852047
 */
public class evalRPN_150 {
    class Solution {
        // 80.23%
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();
            for(String t: tokens){
                if(t.equals("+")){
                    stack.push(stack.pop() + stack.pop());
                }else if(t.equals("*")){
                    stack.push(stack.pop() * stack.pop());
                }else if(t.equals("-")){
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                }else if(t.equals("/")){
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a / b);
                }else{
                    stack.push(Integer.valueOf(t));
                }
            }
            return stack.pop();
        }
    }
}
