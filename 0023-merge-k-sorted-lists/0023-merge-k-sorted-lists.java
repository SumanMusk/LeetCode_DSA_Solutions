class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val-b.val);
        for(ListNode ls: lists) 
            if(ls != null) 
                minHeap.add(ls);

        ListNode start = new ListNode();
        ListNode main = start;
        while(!minHeap.isEmpty()) {
            ListNode temp = minHeap.poll();
            start.next = new ListNode(temp.val);
            start = start.next;
            temp = temp.next;
            if(temp != null)
                minHeap.add(temp);
        }
        return main.next;
    }
}

/*class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null)
            return list2;
        else if(list2 == null)
            return list1;
        else{
            ListNode head = new ListNode();
            ListNode curr = head;
            while(list1 != null && list2 != null){
                if(list1.val == list2.val){
                    curr.next = new ListNode(list1.val);
                    curr = curr.next;
                    list1 = list1.next;
                    curr.next = new ListNode(list2.val);
                    curr = curr.next;
                    list2 = list2.next;
                }
                else if(list1.val < list2.val){
                    curr.next = new ListNode(list1.val);
                    curr = curr.next;
                    list1 = list1.next;
                }
                else{
                    curr.next = new ListNode(list2.val);
                    curr = curr.next;
                    list2 = list2.next;
                }
            }
            while(list1 != null){
                curr.next = new ListNode(list1.val);
                curr = curr.next;
                list1 = list1.next;
            }
            while(list2 != null){
                curr.next = new ListNode(list2.val);
                curr = curr.next;
                list2 = list2.next;
            }
            return head.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head1=null, head2=null;
        if(lists.length == 0) return head1;
        head1=lists[0];
        if(lists.length == 1) return head1;
        else {
            for(int i=1;i<lists.length;i++) {
                head2 = lists[i];
                head1 = mergeTwoLists(head1, head2);
            }
            return head1;
        }
    }
}*/