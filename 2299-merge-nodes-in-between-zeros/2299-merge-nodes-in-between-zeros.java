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