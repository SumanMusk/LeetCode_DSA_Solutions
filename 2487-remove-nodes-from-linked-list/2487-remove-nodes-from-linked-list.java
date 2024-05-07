// Using monotomic Stack
class Solution {
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stk = new Stack<>();        
        while(head != null) {
            while(!stk.isEmpty() && stk.peek().val < head.val)
                stk.pop();
            stk.push(head);
            head = head.next;
        }
        ListNode dummy = new ListNode();
        ListNode start = null;
        int f=0;
        // Adding nodes from the start
        while(!stk.isEmpty()) {
            start = stk.pop();
            if(f == 0) {
                dummy = start;
                dummy.next = null;
                f = 1;
            }
            else {
                start.next = dummy;
                dummy = start;
            }
        }
        return start;
    }
}
/*
// Using Monotonic Deque
class Solution {
    public ListNode removeNodes(ListNode head) {
        Deque<ListNode> mntcQue = new LinkedList<>();        
        while(head != null) {
            while(!mntcQue.isEmpty() && mntcQue.getLast().val < head.val)
                mntcQue.removeLast();
            mntcQue.add(head);
            head = head.next;
        }
        ListNode dummy = new ListNode();
        ListNode start = dummy;
        int f=0;
        while(!mntcQue.isEmpty()) {
            dummy.next = mntcQue.poll();
            dummy = mntcQue.isEmpty() ? null : dummy.next;
        }
        return start.next;
    }
}
// Brute-force: Each time the algorithm gonna find the maximum value and after finding that, that maximum value consisting node is added into the new result LinkedList and the head pointer gonna shift the next node of that maximum value node. Then the next maximum value searching process is implemented on sub-LinkedList from the next node of the previously founded maximum value node to the last node of the given LinkedList.
class Solution {
    public ListNode removeNodes(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode();
        ListNode start = dummy;
        while(head != null) {
            ListNode curr = head.next;
            ListNode backUp = head;
            while(curr != null) {
                if(backUp.val < curr.val) 
                    backUp = curr;
                curr = curr.next;
            }
            dummy.next = backUp;
            head = backUp.next;
            dummy = dummy.next;
        }
        return start.next;
    }
}*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */