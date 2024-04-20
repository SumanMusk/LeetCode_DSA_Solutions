class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        if(maxHeap.size() - minHeap.size() > 1 || (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()))
            minHeap.add(maxHeap.poll());
        if(minHeap.size() - maxHeap.size() > 1)
            maxHeap.add(minHeap.poll());
    }
    
    public double findMedian() {
        if((maxHeap.size() + minHeap.size()) % 2 == 0)
            return (double)(maxHeap.peek() + minHeap.peek()) / 2;
        else {
            if(maxHeap.size() > minHeap.size())
                return maxHeap.peek();
            else return minHeap.peek();
        }
    }
}
/*class MedianFinder {
    List<Integer> ls;
    public MedianFinder() {
        ls = new ArrayList<>();
    }
    
    public void addNum(int num) {
        ls.add(num);
    }
    
    public double findMedian() {
        ls.sort(null);
        return (ls.size() % 2 == 0) ? (double)(ls.get(ls.size()/2) + ls.get((ls.size()/2)-1)) / 2 : (double)ls.get(ls.size()/2);
    }
}*/

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */