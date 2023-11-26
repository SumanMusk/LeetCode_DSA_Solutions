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
    public ListNode rev(ListNode head){
        ListNode ptr1 = null;
        ListNode ptr2 = null;
        while (head != null) {
            ptr2 = ptr1;
            ptr1 = head;
            head = head.next;
            ptr1.next = ptr2;
        }
        return ptr1;
    }
    public void reorderList(ListNode head) {
        if(head != null){
            ListNode slow=head,fast=head;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode x = slow;
            slow = slow.next;
            x.next = null;

            Solution obj = new Solution();
            slow = obj.rev(slow);
            ListNode curr = head;
            while(slow != null){
                ListNode a = slow;
                ListNode b = curr;
                slow = slow.next;
                curr = curr.next;
                a.next = b.next;
                b.next = a;
            }
        }
    }
}