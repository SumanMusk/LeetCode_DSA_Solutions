class Solution {
    public int swimInWater(int[][] grid) {
        int res = 0;
        Queue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        minHeap.add(new int[]{grid[0][0], 0, 0});
        Set<Integer> visited = new HashSet<>();
        int[][] quards = {
            {0,1},
            {1,0},
            {0,-1},
            {-1,0}
        };
        while(!minHeap.isEmpty()) {
            int arr[] = minHeap.poll();
            int val = arr[0];
            int i = arr[1];
            int j = arr[2];
            if(visited.contains(val))
                continue;
            visited.add(val);
            res = Math.max(res, val);
            if(i == grid.length-1 && j == grid[0].length-1)
                break; 
            for(int nei[]: quards) {
                int x = nei[0] + i;
                int y = nei[1] + j;
                if(x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && !visited.contains(grid[x][y]))
                    minHeap.add(new int[]{grid[x][y], x, y});
            }
        }
        return res;
    }
}