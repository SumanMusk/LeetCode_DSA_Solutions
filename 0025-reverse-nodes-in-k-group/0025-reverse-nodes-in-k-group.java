class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1) return head;
        else {
            int f=0;
            ListNode main = head;
            // after reversing, for connecting the right part of the linkedlist with the left reversed part, this "start" pointer always pointed on the last node of the left reversed Linkedlist (for 3 -> 4 reversal, the "start" pointer will point on node 1)
            ListNode start = new ListNode();
            // Same pointer as the "curr" pointer in Reverse the whole LinkedList question
            ListNode curr = head;
            while(head != null) {
                // Placing the head pointer into the k-th pointer of the given LinkedList
                int x = k;
                while(head != null && x > 1) {
                    head = head.next;
                    x--;
                }
                // After 5 node, there's no k-th node. So this if statement gonna check whether there's any k-th element or not
                if(head == null) break;
                // Reversing part (the "prev" pointer is pointed at the next node of the k-th node because the leftmost node of the reversable sub-LinkedList should connect with the (k+1)-th node of the given LinkedList (for sub-LinkedList 1->2, after reversing the sub-LinkedList, the 1 node should connect to the node 3 (2->1->3)))
                ListNode temp=null, prev=head.next;
                x = k;
                while(x > 0) {
                    temp = curr;
                    curr = curr.next;
                    temp.next = prev;
                    prev = temp;
                    x--;
                }
                // After the reversing of the sub-LinkedList, the first node of the reversed sub-LinkedList(for 3->4: after reversal 4->3 so the first node became 4) should connect with the last node of the previous reversed and connected LinkedList( for 3->4 after reversal 4->3 and the 4 should connect with node 1, so the main LinkedList became 2->1->4->3)
                start.next = temp;
                start = start.next;
                // For the first iteration, the "main" Node is pointed with the first node of the first reversed sub-linkedlist
                if(f == 0) {
                    main = temp;
                    f = 1;
                }
                x = k;
                while(x > 1) {
                    start = start.next;
                    x--;
                }
                // By reversing the sub-LinkedLists, the head node pointer still pointes to the same node before reversing. So after reversing, the head pointer won't gonna point to the k+1-th node(1->2 ==> 2->1 and the head pointer is pointing the 2 node). But the curr pointer will always pointing to the k+1-th node after reversing.
                head = curr;
            }
            return main;
        }
    }
}