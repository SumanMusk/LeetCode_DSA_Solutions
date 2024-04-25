class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: hand)
            map.put(i, map.getOrDefault(i, 0)+1);
        Arrays.sort(hand);
        int i=0, j=0;
        while(i < hand.length && !map.isEmpty()) {
            int temp = hand[i]; 
            if(!map.containsKey(temp)) {
                i++;
                continue;
            }
            for(j=temp;j<(temp+groupSize);j++) {
                if(!map.containsKey(j)) return false;
                map.put(j, map.get(j)-1);
                if(map.get(j) == 0) {
                    map.remove(j);
                }
            }
            i++;
        }
        return true;
    }
}
/*class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: hand)
            map.put(i, map.getOrDefault(i, 0)+1);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(map.keySet());        
        while(!minHeap.isEmpty()) {
            int temp = minHeap.peek();
            for(int i=temp;i<(temp+groupSize);i++) {
                if(!map.containsKey(i)) return false;
                map.put(i, map.get(i)-1);
                if(map.get(i) == 0) {
                    map.remove(i);
                    minHeap.poll();
                }
            }
        }
        return true;
    }
}*/