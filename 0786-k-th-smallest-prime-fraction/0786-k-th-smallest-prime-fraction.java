class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Double.compare((double)b[0]/b[1], (double)a[0]/a[1]));
        for(int i=0;i<arr.length-1;i++) {
            for(int j=i+1;j<arr.length;j++) {
                maxHeap.add(new int[]{arr[i], arr[j]});
                if(maxHeap.size() > k)
                    maxHeap.poll();
            }
        }
        return maxHeap.poll();
    }
}