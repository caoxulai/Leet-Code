/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author I852047
 */
public class NestedIterator_341 {
    // 87.07%
    public class NestedIterator implements Iterator<Integer> {
        List<Integer> list;
        int cur;
        
        public NestedIterator(List<NestedInteger> nestedList) {
            list = new ArrayList<>();
            cur = 0;
            flatten(list, nestedList);
        }
        
        private void flatten(List<Integer> list, List<NestedInteger> nestedList){
            for(NestedInteger ni: nestedList){
                if(ni.isInteger())
                    list.add(ni.getInteger());
                else
                    flatten(list, ni.getList());
            }
        }
        
        @Override
        public Integer next() {
            return list.get(cur++);
        }
        
        @Override
        public boolean hasNext() {
            return cur < list.size();
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
