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