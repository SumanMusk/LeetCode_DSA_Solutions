class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<k;i++)
            minHeap.add(nums[i]);
        for(int i=k;i<nums.length;i++) {
            if(nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.peek();
    }
}
/*class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i: nums)
            maxHeap.add(i);
        for(int i=0;i<k-1;i++)
            maxHeap.poll();
        return maxHeap.peek();
    }
}*/