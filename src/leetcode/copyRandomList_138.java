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
public class copyRandomList_138 {
    public class Solution {
        public RandomListNode copyRandomList(RandomListNode head) {
            if(head == null)    return null;
            HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
            RandomListNode node = head;
            while(node!=null){
                map.put(node, new RandomListNode(node.label));
                node = node.next;
            }
            node = head;
            while(node!=null){
                map.get(node).next = map.get(node.next);
                map.get(node).random = map.get(node.random);
                node = node.next;
            }
            
            return map.get(head);
        }
    }
    
    
    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }
}