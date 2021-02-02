package leetcode;

import leetcode.util.ListNode;

import java.util.HashSet;
import java.util.Set;

public class numComponents_817 {
    public int numComponents(ListNode head, int[] G) {
        // create input int array into a hash set
        Set<Integer> set = new HashSet();
        for(int g : G) {
            set.add(g);
        }

        int count = 0;
        boolean prev = false;
        while(head != null) {
            if(set.contains(head.val)) {
                // if the previous node is not in the list, it means this node is the beginning of a connected component.
                // Increase the count, set the flag
                if(!prev){
                    count++;
                    prev = true;
                }
            }
            // clear the flag
            else
                prev = false;
            head = head.next;
        }
        return count;
    }
}
