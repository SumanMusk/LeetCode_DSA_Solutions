class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int arr[] = new int[]{-1,-1};
        if(head.next == null || head.next.next == null)
            return arr;
        ListNode prev=head, curr=head.next, nextnode=head.next.next;
        int idx=1, f=0, startingVal=0, minimum=Integer.MAX_VALUE, endingVal=0, prevVal=Integer.MIN_VALUE, currVal=Integer.MIN_VALUE;
        while(nextnode != null) {
            if((curr.val > prev.val && curr.val > nextnode.val) || (curr.val < prev.val && curr.val < nextnode.val)) {
                if(f == 0) {
                    startingVal = idx;
                    f = 1;
                }
                endingVal = idx;
                currVal = idx;
                if(prevVal != Integer.MIN_VALUE) 
                    minimum = Math.min(minimum, currVal-prevVal);
                prevVal = idx;                
            }
            prev = prev.next;
            curr = curr.next;
            nextnode = nextnode.next;
            idx++;
        }
        arr[0] = minimum == Integer.MAX_VALUE ? -1 : minimum;
        arr[1] = (endingVal - startingVal == 0) ? -1 : endingVal - startingVal;
        return arr;
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