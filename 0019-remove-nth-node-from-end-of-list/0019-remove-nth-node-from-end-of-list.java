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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null)
            return null;
        else{
            ListNode dummy = new ListNode(Integer.MIN_VALUE);
            dummy.next = head;
            ListNode l = dummy,r = head;
            while(n > 0){
                r = r.next;
                n--;
            }
            while(r != null){
                l =l.next;
                r =r.next;
            }

            l.next = l.next.next;
            return dummy.next;
        }
    }
}