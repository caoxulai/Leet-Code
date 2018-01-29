/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 *
 * @author Bryce
 */
public class LRUCache_146 {
    // Using LinkedHashSet tyep to find the LRUKey in O(1)
    class LRUCache {
    int cap;
    
    HashMap<Integer, Integer> keyToValue;
    LinkedHashSet<Integer> keys;

    public LRUCache(int capacity) {
        cap = capacity;
        keyToValue = new HashMap<>();
        keys = new LinkedHashSet<>();        
    }
    
    public int get(int key) {
        if(keys.contains(key)){
            keys.remove(key);
            keys.add(key);
            return keyToValue.get(key);
        }
        return -1;        
    }

    public void put(int key, int value) {
        if(keys.contains(key)){
            keyToValue.put(key, value);
            get(key);
        }
        else{
            if(keys.size() == cap){
                // the key is here.
                // LinkedHashSet has its own iterator which will point its first element
                int LRUKey = keys.iterator().next();
                keyToValue.remove(LRUKey);
                keys.remove(LRUKey);
            }
            keyToValue.put(key, value);
            keys.add(key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
