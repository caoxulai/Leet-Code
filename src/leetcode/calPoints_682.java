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
        int total = 0;
        Stack<Integer> points = new Stack<>();
        for(String op : ops){
            if(op.equals("+")){
                int last = points.pop();
                int point = points.peek() + last;
                total += point;
                points.push(last);
                points.push(point);
            }else if(op.equals("C")){
                int top = points.pop();
                total -= top;
            }else if(op.equals("D")){
                int point = points.peek() * 2;
                total += point;
                points.push(point);
            }else{
                int point = Integer.valueOf(op);
                total += point;
                points.push(point);
            }
        }
        return total;
    }
}
