/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author Bryce
 */
public class RandomizedSet {
    ArrayList<Integer> nums;
    HashMap<Integer, Integer> pos;
    Random rand;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        rand = new java.util.Random();        
        nums= new ArrayList<>();
        pos = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(pos.containsKey(val))    return false;
        pos.put(val, nums.size());
        nums.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!pos.containsKey(val))    return false;
        int p = pos.get(val);
        if(p!=nums.size()-1){
            int lastVal = nums.get(nums.size()-1);
            nums.set(p, lastVal);
            pos.put(lastVal, p);     
        }
        nums.remove(nums.size()-1);
        pos.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}
