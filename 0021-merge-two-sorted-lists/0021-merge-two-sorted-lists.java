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
    public ListNode add(ListNode head, int x){
        ListNode temp = new ListNode(x, null);
        if(head == null)
            head = temp;
        else{
            ListNode curr = head;
            while(curr.next != null)
                curr = curr.next;
            curr.next = temp;
        }
        return head;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        Solution obj = new Solution();
        if(list1 == null)
            return list2;
        else if(list2 == null)
            return list1;
        else{
            ListNode head = null;
            while(list1 != null && list2 != null){
                if(list1.val == list2.val){
                    head = obj.add(head, list1.val);
                    list1 = list1.next;
                    head = obj.add(head, list2.val);
                    list2 = list2.next;
                }
                else if(list1.val < list2.val){
                    head = obj.add(head, list1.val);
                    list1 = list1.next;
                }
                else{
                    head = obj.add(head, list2.val);
                    list2 = list2.next;
                }
            }
            while(list1 != null){
                head = obj.add(head, list1.val);
                list1 = list1.next;
            }
            while(list2 != null){
                head = obj.add(head, list2.val);
                list2 = list2.next;
            }
            return head;
        }
    }
}