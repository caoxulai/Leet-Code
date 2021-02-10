package leetcode;

public class MyLinkedList_707 {

    class MyLinkedList {

        class Node {
            int val;
            Node next;
            public Node(int val) {
                this.val = val;
            }
        }

        private Node head;
        private int size;

        /** Initialize your data structure here. */
        public MyLinkedList() {
            head = new Node(0);
            size = 0;
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            if(index >= size)
                return -1;
            Node tmp = getNodeAtIndex(index);
            return tmp.next.val;
        }

        private Node getNodeAtIndex(int index) {
            Node tmp = head;
            for (int i = 0; i < index; i++) {
                tmp = tmp.next;
            }
            return tmp;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if(index > size)
                return;

            Node tmp = getNodeAtIndex(index);

            Node node = new Node(val);
            node.next = tmp.next;
            tmp.next = node;

            size++;
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if(index >= size)
                return;

            Node tmp = getNodeAtIndex(index);
            tmp.next = tmp.next.next;

            size--;
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
}
