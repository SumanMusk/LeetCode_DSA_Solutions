class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adjLs = new HashMap<>();
        for(int i=1;i<=n;i++)
            adjLs.put(i, new ArrayList<>());
        for(int arr[]: times) 
            adjLs.get(arr[0]).add(new int[]{arr[2], arr[1]});
        Queue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        minHeap.add(new int[]{0, k});
        Set<Integer> visited = new HashSet<>();
        int res=0, f=0, ans = Integer.MIN_VALUE;
        while(!minHeap.isEmpty()) {
            int arr[] = minHeap.poll();
            int node = arr[1];
            int cost = arr[0];
            if(visited.contains(node))
                continue;
            visited.add(node);
            res = Math.max(res, cost);
            for(int nei[]: adjLs.get(node)) {
                int neiNode = nei[1];
                int neiCost = nei[0];
                if(!visited.contains(neiNode)) 
                    minHeap.add(new int[]{res + neiCost, neiNode});
            }
        }
        // Checking of Dis-Connected Graph and Cyclic Graph
        if(visited.size() < n)
            return -1;
        return res;
    }
}