/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head != null){
            ListNode s=head,f=head.next;
            int flag=0;
            while(f != null && f.next != null){
                if(s == f){
                    flag=1;
                    break;
                }
                s=s.next;
                f=f.next.next;
            }
            if(flag == 1) return true;
            else return false;
        }
        else return false;
    }
}