class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adjLs = new HashMap<>();
        for(int[] arr : flights) {
            int s = arr[0];
            int dest = arr[1];
            int cost = arr[2];
            adjLs.computeIfAbsent(s, key -> new ArrayList<>()).add(new int[]{dest, cost});
        }
        int costArr[] = new int[n];
        Arrays.fill(costArr, Integer.MAX_VALUE);
        costArr[src] = 0;
        // PriorityQueue to store {cost, node, stops}
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0, src});

        while (!que.isEmpty() && k >= 0) {
            int len = que.size();
            for(int i=0;i<len;i++) {
                int[] current = que.poll();
                int cost = current[0];
                int node = current[1];

                List<int[]> neighbors = adjLs.getOrDefault(node, new ArrayList<>());
                for (int[] neighbor : neighbors) {
                    int nextNode = neighbor[0];
                    int nextCost = neighbor[1] + cost;
                    if(nextCost < costArr[nextNode]) {
                        costArr[nextNode] = nextCost;
                        que.add(new int[]{nextCost, nextNode});
                    }
                }
            }
            k--;
        }

        return costArr[dst] == Integer.MAX_VALUE ? -1 : costArr[dst];
    }
}
/*
// Using Dijkstra's Algo
// Because of ei question e no of stops(k) r limit deoa ache, tai alada kore visited Set use korte hoini
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adjLs = new HashMap<>();
        for (int[] arr : flights) {
            int s = arr[0];
            int dest = arr[1];
            int cost = arr[2];
            adjLs.computeIfAbsent(s, key -> new ArrayList<>()).add(new int[]{dest, cost});
        }

        // PriorityQueue to store {cost, node, stops}
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        minHeap.add(new int[]{0, src, 0});

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int cost = current[0];
            int node = current[1];
            int stops = current[2];

            if (node == dst) 
                return cost;

            if (stops <= k) {
                List<int[]> neighbors = adjLs.getOrDefault(node, new ArrayList<>());
                for (int[] neighbor : neighbors) {
                    int nextNode = neighbor[0];
                    int nextCost = neighbor[1];
                    minHeap.add(new int[]{cost + nextCost, nextNode, stops + 1});
                }
            }
        }

        return -1;
    }
}
*/