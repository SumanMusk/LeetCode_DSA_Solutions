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
    public ListNode removeElements(ListNode head, int val) {
        ListNode curr = head;
        int f=0;
        if(curr != null){
            while(curr.next != null){
                int x = curr.next.val;
                if(x == val) curr.next = curr.next.next;
                else curr = curr.next;
            }
            if(head.val == val) head = head.next;
        }
        return head;
    }
}