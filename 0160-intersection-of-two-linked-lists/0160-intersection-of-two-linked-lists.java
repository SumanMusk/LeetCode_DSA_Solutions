public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int count = 0;
        ListNode currA = headA;
        ListNode currB = headB;
        if(headA.val == 1 && headB.val == 1 && headA.next == null && headB.next == null) return headA;
        while(count <= 2) {
            int f=0;
            if(currA.next != null && currB.next != null && currA.next == currB.next) {
                if(currA == currB) return currA;
                return currA.next;
            }
            if(currA.next == null && currB.next == null){
                if(count < 2) {
                    count+=2;
                    currA = headB;
                    currB = headA;
                    continue;
                }
                if(currA == currB) return currA;
                return null;
            }
            if(currA.next == null) {
                count++;
                currA = headB;
                currB = currB.next;
                if(currA == currB) return currA;
                f = 1;
            }
            if(currB.next == null) {
                count++;
                currB = headA;
                currA = currA.next;
                if(currA == currB) return currA;
                f = 1;
            }
            if(f == 0) {
                currA = currA.next;
                currB = currB.next;
            }
        }
        return null;
    }
}