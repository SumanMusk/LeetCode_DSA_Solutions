class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode curr=head, temp=head, endPoint=null;
        int c=0, f=0;
        while(curr != null) {
            if(curr.val == 0 && c > 0) {
                temp.val = c;
                endPoint = temp;
                temp = temp.next;
                c=0;
            }
            else 
                c += curr.val;
            curr = curr.next;
        }
        endPoint.next = null;
        return head;
    }
}

// Using extra space
/*
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode start=null, curr=null, temp=head;
        int c=0;
        while(temp != null) {
            if(temp.val == 0 && c > 0) {
                ListNode x = new ListNode(c);
                if(start == null) {
                    start = x;
                    curr = start;
                }
                else {
                    curr.next = x;
                    curr = x;
                }
                c=0;
            }
            else 
                c += temp.val;
            temp = temp.next;
        }
        return start;
    }
}
*/