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
public class calPoints_682 {
    public int calPoints(String[] ops) {
        int res=0;
        Stack<Integer>  stack = new Stack<>();
        for(String op: ops){
            if(op.equals("C")){
                int last = stack.pop();
                res -= last;
            }
            else if(op.equals("D")){
                int point = stack.peek()*2;
                res += point;
                stack.push(point);
            }
            else if(op.equals("+")){
                int last = stack.pop();
                int point = stack.peek() + last;
                res += point;
                stack.push(last);
                stack.push(point);
            }
            else{                
                int point = Integer.valueOf(op);
                res += point;
                stack.push(point);
            }
        }
        return res;
    }
}
