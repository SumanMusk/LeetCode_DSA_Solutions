class Solution {
    public int minCostConnectPoints(int[][] points) {
        if(points.length == 1)
            return 0;
        Map<Integer, List<int[]>> adjLs = new HashMap<>();
        for(int i=0;i<points.length;i++) {
            for(int j=0;j<points.length;j++) {
                int x = Math.abs(points[i][0] - points[j][0]);
                int y = Math.abs(points[i][1] - points[j][1]);
                if(x+y != 0)
                    adjLs.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[]{j, x+y});
            }
        }
        int c=0;
        Queue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        Set<Integer> visited = new HashSet<>();
        minHeap.add(new int[]{0, 0});
        while(!minHeap.isEmpty()) {
            int arr[] = minHeap.poll();
            int node = arr[0];
            int cost = arr[1];
            if(visited.contains(node))
                continue;
            visited.add(node);
            c += cost;
            
            for(int nei[]: adjLs.get(node)) {
                int neiNode = nei[0];
                if(!visited.contains(neiNode))
                    minHeap.add(nei);
            }
        }
        return c;
    }
}