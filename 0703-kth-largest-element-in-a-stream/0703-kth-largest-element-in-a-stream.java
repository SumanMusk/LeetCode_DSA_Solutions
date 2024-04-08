class KthLargest {
    PriorityQueue<Integer> que = new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        if(nums.length > 0) {
            if(nums.length > k) {
                for(int i=0;i<k;i++)
                    que.add(nums[i]);
                for(int i=k;i<nums.length;i++) 
                    add(nums[i]);
            }
            else {
                for(int i=0;i<nums.length;i++) 
                    que.add(nums[i]);
            }
        }
    }
    
    public int add(int val) {
        if(que.size() < k) que.add(val);
        else if(val > que.peek()) {
            que.poll();
            que.add(val);
        }
        return que.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */