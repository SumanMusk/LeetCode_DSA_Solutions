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
    public ListNode reverseList(ListNode head) {
        ListNode prev=null,temp=null,curr=head;
        while(curr!=null){
            temp = curr;
            curr = curr.next;
            temp.next = prev;
            prev = temp;
        }
        head = temp;
        return head;
    }
}