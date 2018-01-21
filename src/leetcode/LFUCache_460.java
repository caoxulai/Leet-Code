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
public class LFUCache_460 {
    public static void main(String [] args)
    {
        LFUCache_460 obj = new LFUCache_460(2);


        obj.put(2,1);
        obj.put(3,2);
        System.out.println(obj.get(3));
        System.out.println(obj.get(2));
        obj.put(4,3);
        System.out.println("key "+ 4 +" count "+ 3 );
        System.out.println(obj.get(2));
        System.out.println(obj.get(3));
        System.out.println(obj.get(4));
    }
    
    
    int minCount;
    int cap;
    
    HashMap<Integer, Integer> keyToValue;
    HashMap<Integer, Integer> keyToCount;
    HashMap<Integer, LinkedHashSet> CountToKeys;
    

    public LFUCache_460(int capacity) {
        minCount = -1;
        cap = capacity;   
        keyToValue = new HashMap<>();
        keyToCount = new HashMap<>();
        CountToKeys = new HashMap<>();        
    }
    
    public int get(int key) {
        if(!keyToValue.containsKey(key))    return -1;
        int count = keyToCount.get(key);
        
        
        
        LinkedHashSet<Integer> currSet = CountToKeys.get(count);
        currSet.remove(key);
        if(count==minCount && currSet.isEmpty()){
            minCount++;
            CountToKeys.remove(count);
        }
        keyToCount.put(key, count+1);
        LinkedHashSet<Integer> nextSet = CountToKeys.getOrDefault(count+1, new LinkedHashSet<>());
        nextSet.add(key);
        CountToKeys.put(count+1, nextSet);
        return keyToValue.get(key);
    }
    
    public void put(int key, int value) {        
        if(cap<=0)
            return;
        if(keyToValue.containsKey(key)){
            keyToValue.put(key, value);
            get(key);
        }
        else{
            if(cap == keyToValue.size()){
                LinkedHashSet<Integer> LFUSet = CountToKeys.get(minCount);
                int LFUKey = LFUSet.iterator().next();
                LFUSet.remove(LFUKey);
                keyToValue.remove(LFUKey);
                keyToCount.remove(LFUKey);
                if(LFUSet.isEmpty())    CountToKeys.remove(minCount);
            }
            minCount = 1;
            LinkedHashSet<Integer> targetSet = CountToKeys.getOrDefault(minCount, new LinkedHashSet<>());
            targetSet.add(key);
            keyToValue.put(key, value);
            keyToCount.put(key, minCount);
            CountToKeys.put(minCount, targetSet);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */