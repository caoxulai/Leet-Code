package leetcode;

public class FrontMiddleBackQueue_1670 {
    class FrontMiddleBackQueue {
        private class ListNode {
            public int val;
            public ListNode next;
            public ListNode() {}
            public ListNode(int x) { val = x; }
            public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        }

        private int size;
        private ListNode head;

        public FrontMiddleBackQueue() {
            size = 0;
            head = new ListNode();
        }

        public void pushFront(int val) {
            insertAtIndex(val, 0);
        }

        public void pushMiddle(int val) {
            int index = size/2;
            insertAtIndex(val, index);
        }

        public void pushBack(int val) {
            insertAtIndex(val, size);
        }

        private void insertAtIndex(int val, int index) {
            ListNode node = new ListNode(val);
            ListNode insertAfter = getNodeAt(index);
            node.next = insertAfter.next;
            insertAfter.next = node;
            size++;
        }

        public int popFront() {
            return popAtIndex(0);
        }

        public int popMiddle() {
            return popAtIndex((size - 1) / 2);
        }

        public int popBack() {
            return popAtIndex(size-1);
        }

        private int popAtIndex(int index) {
            if(size == 0)
                return -1;

            ListNode popAfter = getNodeAt(index);

            int ans = popAfter.next.val;
            popAfter.next = popAfter.next.next;
            size--;

            return ans;
        }

        private ListNode getNodeAt(int index) {
            ListNode tmp = head;
            for(int i=0; i<index; i++) {
                tmp = tmp.next;
            }
            return tmp;
        }
    }

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */
}
