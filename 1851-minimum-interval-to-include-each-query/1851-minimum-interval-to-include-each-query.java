class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int backup[] = Arrays.copyOf(queries, queries.length);
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        Arrays.sort(queries);
        Queue<List<Integer>> minHeap = new PriorityQueue<>((a,b) -> a.get(0)-b.get(0));
        int x=0;
        for(int i: queries) {
            int f=0;
            while(x < intervals.length && intervals[x][0] <= i) {
                minHeap.add(new ArrayList<>(Arrays.asList((intervals[x][1]-intervals[x][0])+1, intervals[x][1])));
                x++;
            }
            while(!minHeap.isEmpty() && minHeap.peek().get(1) < i)
                minHeap.poll();
            map.put(i, minHeap.isEmpty() ? -1 : minHeap.peek().get(0));
        }
        int ans[] = new int[queries.length];
        int c=0;
        for(int i: backup)
            ans[c++] = map.get(i);
        return ans;
    }
}