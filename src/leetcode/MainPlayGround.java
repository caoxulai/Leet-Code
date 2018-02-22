/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author Bryce
 */
public class MainPlayGround {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>(){
            public int compare(String a, String b){
                return b.compareTo(a);
            }
        });
        queue.offer("123");
        queue.offer("12z");
        queue.offer("12");
        queue.offer("2132");
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        
    }
    
}
