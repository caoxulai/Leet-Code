/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.HashMap;

/**
 *
 * @author Bryce
 */
public class LRUCache_146_1 {
    class LRUCache {
        DNode head;
        DNode tail;
        HashMap<Integer, DNode> map;
        int cap;
        
        class DNode{
            DNode pre;
            DNode next;
            int key;
            int val;
            public DNode(int k, int v){
                key = k;
                val = v;
                pre = null;
                next = null;
            }
        }
        
        private void deleteNode(DNode node){
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        
        private void deleteLastNode(){
            tail.pre = tail.pre.pre;
            tail.pre.next = tail;
        }
        
        private void addNode(DNode node){
            node.next = head.next;
            node.next.pre = node;
            head.next = node;
            node.pre = head;
        }
        
        
        public LRUCache(int capacity) {
            head = new DNode(0, 0);
            tail = new DNode(0, 0);
            head.next = tail;
            tail.pre = head;
            map = new HashMap<>();
            cap = capacity;
        }
        
        public int get(int key) {
            if(map.containsKey(key)){
                DNode temp = map.get(key);
                deleteNode(temp);
                addNode(temp);
                return temp.val;
            }
            else
                return -1;
        }
        
        public void put(int key, int value) {
            DNode temp = new DNode(key, value);
            
            // System.out.println(key +" : "+value);
            
            
            if(map.containsKey(key)){
                DNode existed = map.get(key);
                deleteNode(existed);
                addNode(temp);
                map.put(key, temp);
            }
            else{
                if(cap==0){
                    DNode last = tail.pre;
                    map.remove(last.key);
                    // System.out.println(last.val);
                    deleteLastNode();
                    cap++;
                }
                addNode(temp);
                map.put(key, temp);
                cap--;
            }
            // p();
        }
        
        private void p(){
            DNode temp = head.next;
            
            while(temp.next!=null){
                System.out.print(temp.key + " -> ");
                temp = temp.next;
            }
            System.out.println( " ");
        }
    }
    
    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    
}
