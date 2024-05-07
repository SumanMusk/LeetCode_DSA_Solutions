// Solved by Reversing the LinkedList
class Solution {
    public ListNode reverse(ListNode head) {
        ListNode temp=null, prev=null, curr=head;
        while(curr != null) {
            temp = curr;
            curr = curr.next;
            temp.next = prev;
            prev = temp;
        }
        return prev;
    }
    public ListNode doubleIt(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null && head.val == 0) 
            return head;
        head = reverse(head);
        ListNode curr=head;
        int rmndr=0;
        while(curr != null) {
            int tVal = (curr.val*2)+rmndr;
            curr.val = tVal % 10;
            if(tVal >= 10)
                rmndr = tVal/10;
            else
                rmndr = 0;
            if(curr.next == null && rmndr != 0) {
                curr.next = new ListNode(rmndr);
                break;
            }
            curr = curr.next;
        }
        return reverse(head);
    }
}
/*
// Without reversing the entire LinkedList, we can simply store all the nodes into a Stack
class Solution {
    public ListNode doubleIt(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null && head.val == 0) 
            return head;
        Stack<ListNode> stk = new Stack<>();
        ListNode curr=head;
        while(curr != null) {
            stk.push(curr);
            curr = curr.next;
        }
        int rmndr=0;
        while(!stk.isEmpty()) {
            curr = stk.pop();
            int tVal = (curr.val*2)+rmndr;
            curr.val = tVal % 10;
            if(tVal >= 10)
                rmndr = tVal/10;
            else
                rmndr = 0;
        }
        if(rmndr != 0) {
            ListNode node = new ListNode(rmndr);
            node.next = head;
            head = node;
        }
        return head;
    }
}

// Brute-Force
class Solution {
    public ListNode doubleIt(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null && head.val == 0) 
            return head;
        int num=0;
        while(head != null) {
            num = num*10 + head.val;
            head = head.next;
        }
        num *= 2;
        ListNode dummy = new ListNode();
        ListNode start = null;
        int f=0;
        while(num != 0) {
            start = new ListNode(num%10);
            if(f == 0) {
                dummy = start;
                f = 1;
            }
            else {
                start.next = dummy;
                dummy = start;
            }
            num /= 10;
        }
        return start;
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