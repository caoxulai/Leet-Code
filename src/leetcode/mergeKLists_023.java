/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import leetcode.util.ListNode;

import java.util.PriorityQueue;

/**
 *
 * @author Bryce
 */
public class mergeKLists_023 {
    // Using Priorityqueue type to sort the unsorted lists
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode(0), curr=res;
        if(lists==null || lists.length==0)  return res.next;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b)->Integer.compare(a.val, b.val));
        for(ListNode node: lists){
            if(node!=null)  queue.offer(node);
        }
        while(!queue.isEmpty()){
            curr.next = queue.poll();
            curr = curr.next;
            if(curr.next !=null){
                queue.offer(curr.next);
            }
        }
        return res.next;
    }
}
