package leetcode;

import java.util.PriorityQueue;

public class KthLargest_703 {

    public static void main(String [] args) {
        KthLargest obj = new KthLargest(1, new int[0]);
        System.out.println(obj.add(-3));
        System.out.println(obj.add(-2));
        System.out.println(obj.add(-4));
        System.out.println(obj.add(0));
        System.out.println(obj.add(4));
    }

    static class KthLargest {

        int k;
        PriorityQueue<Integer> queue;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            queue = new PriorityQueue<>((a, b) -> a-b);
            for (int num : nums) {
                queue.offer(num);
            }

        }

        public int add(int val) {
            queue.offer(val);
            while(queue.size() > k) {
                queue.poll();
            }
            return queue.peek();
        }
    }
}
