class Solution {
    public int minDifference(int[] nums) {
        if(nums.length <= 4)
            return 0;
        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> maxOnes = new ArrayList<>();
        List<Integer> minOnes = new ArrayList<>();
        for(int i: nums) {
            minHeap.add(i);
            maxHeap.add(i);
        }
        for(int x=0;x<4;x++) {
            maxOnes.add(maxHeap.poll());
            minOnes.add(minHeap.poll());
        }
        int ans = Integer.MAX_VALUE;
        for(int x=1;x<=4;x++) 
            ans = Math.min(ans, maxOnes.get(4-x)-minOnes.get(x-1));
        return ans;
    }
}
/*
class Solution {
    public int minDifference(int[] nums) {
        if(nums.length <= 4)
            return 0;
        Arrays.sort(nums);
        int ans=Integer.MAX_VALUE, i=0, j=nums.length-4;
        for(int x=0;x<4;x++) 
            ans = Math.min(ans, nums[j++]-nums[i++]);
        return ans;
    }
}
*/