/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author I852047
 */
public class NestedIterator_341_1 {
    // using stack
    public class NestedIterator implements Iterator<Integer> {
        Stack<NestedInteger> stack;
        
        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new Stack<>();
            for(int i=nestedList.size()-1; i>=0; i--){
                stack.push(nestedList.get(i));
            }
        }
        
        @Override
        public Integer next() {
            hasNext();
            return stack.pop().getInteger();
        }
        
        @Override
        public boolean hasNext() {
            while(!stack.isEmpty() && !stack.peek().isInteger()){
                List<NestedInteger> nestedList = stack.pop().getList();
                for(int i=nestedList.size()-1; i>=0; i--){
                    stack.push(nestedList.get(i));
                }
            }
            return !stack.isEmpty();
        }
    }
    
    public interface NestedInteger {
        
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();
        
        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();
        
        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
