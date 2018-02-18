/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Bryce
 */
public class connectTreeLinkNodeAnyStructure_117 {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) {
            val = x;
        }
    }
    
    public class Solution {
        // 27.67%
        // O(n) space, O(n) time.
        public void connect(TreeLinkNode root) {
            if(root == null)    return;
            Queue<TreeLinkNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                TreeLinkNode pre = null;
                for(int i=0; i<size; i++){
                    TreeLinkNode cur = queue.poll();
                    if(pre != null) pre.next = cur;
                    pre = cur;
                    if(cur.left != null)    queue.offer(cur.left);
                    if(cur.right != null)    queue.offer(cur.right);
                }
            }
        }
    }
}
