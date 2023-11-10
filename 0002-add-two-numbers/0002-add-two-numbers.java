/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     long val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(long val) { this.val = val; }
 *     ListNode(long val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Solution obj = new Solution();
        ListNode head = null;
        int carry=0;
        while(l1 != null || l2 != null){
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int temp_sum = x + y + carry;
            carry = temp_sum/10;
            ListNode temp = new ListNode(temp_sum%10, null);
            if(head == null)
                head = temp;
            else{
                ListNode curr = head;
                while(curr.next != null)
                    curr = curr.next;
                curr.next = temp;
            }
            // obj.addLast(head, temp_sum%10);
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }        
        if(carry > 0){
            ListNode temp = new ListNode(carry ,null);
            ListNode curr = head;
            while(curr.next != null)
                curr = curr.next;
            curr.next = temp;
            // obj.addLast(head, carry);
        }
        return head;
    }
}