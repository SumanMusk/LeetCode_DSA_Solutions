class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int maxVal = Integer.MIN_VALUE;
        for(int i: nums) 
            maxVal = Math.max(maxVal, i);
        int arr[] = new int[maxVal+1];
        for(int i=0;i<nums.length-1;i++) 
            for(int j=i+1;j<nums.length;j++) 
                arr[Math.abs(nums[j]-nums[i])]++;
        int c=0, f=0;
        while(k != 1) {
            while(arr[c] > 0 && k != 1) {
                arr[c]--;
                k--;
            }
            if(arr[c] != 0 && k == 1) 
                break;
            if(arr[c] == 0 && k == 1) {
                while(arr[c] == 0)
                    c++;
                break;
            }
            c++;
        }
        return c;
    }
}
/*
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<nums.length-1;i++) 
            for(int j=i+1;j<nums.length;j++) 
                addQue(Math.abs(nums[j]-nums[i]), k, maxHeap);
        return maxHeap.peek();
    }
    public void addQue(int num, int k, Queue<Integer> maxHeap) {
        maxHeap.add(num);
        if(maxHeap.size() > k)
            maxHeap.poll();
    }
}
*/