class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i: stones)
            maxHeap.add(i);
        while(maxHeap.size() > 1) {
            int x = maxHeap.poll();
            int y = maxHeap.poll();
            if(x-y > 0) maxHeap.add(x-y);
        }
        return (maxHeap.size() != 0) ? maxHeap.peek() : 0;
    }
}