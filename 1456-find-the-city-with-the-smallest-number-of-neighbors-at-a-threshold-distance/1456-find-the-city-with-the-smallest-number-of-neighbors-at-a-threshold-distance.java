class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int i=0;i<n;i++) 
            map.put(i, new ArrayList<>());
        for(int arr[]: edges) {
            map.get(arr[0]).add(new int[]{arr[1], arr[2]});
            map.get(arr[1]).add(new int[]{arr[0], arr[2]});
        }
        int res=0, minVal = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            int count = dijkstra(i, map, distanceThreshold);
            if(minVal >= count) {
                minVal = count;
                res = i;
            }
        }
        return res;
    }
    public int dijkstra(int source, Map<Integer, List<int[]>> map, int distanceThreshold) {
        Queue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        minHeap.add(new int[]{source, 0});
        Set<Integer> visited = new HashSet<>();
        while(!minHeap.isEmpty()) {
            int node = minHeap.peek()[0];
            int dist = minHeap.peek()[1];
            minHeap.poll();
            if(visited.contains(node))
                continue;
            visited.add(node);
            for(int arr[]: map.get(node)) {
                int curr = arr[0];
                int weight = arr[1];
                int total = dist + weight;
                if(total <= distanceThreshold)
                    minHeap.add(new int[]{curr, total});
            }
        }
        return visited.size()-1;
    }
}