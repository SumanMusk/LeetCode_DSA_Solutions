class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<List<Integer>> que = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();
        for(char c: tasks)
            map.put(c, map.getOrDefault(c, 0)+1);
        Iterator<Character> itr = map.keySet().iterator();
        while(itr.hasNext())
            maxHeap.add(map.get(itr.next()));
        int time=0;
        while(!maxHeap.isEmpty() || !que.isEmpty()) {
            time++;
            if(!maxHeap.isEmpty()) {
                int newFreq = maxHeap.poll()-1;
                if(newFreq > 0) que.add(new ArrayList<>(Arrays.asList(newFreq, (time+n))));
            }
            if(!que.isEmpty() && que.peek().get(1) == time)
                maxHeap.add(que.poll().get(0));
        }
        return time;
    }
}