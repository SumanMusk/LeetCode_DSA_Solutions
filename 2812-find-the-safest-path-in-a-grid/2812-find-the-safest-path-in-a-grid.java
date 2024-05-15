class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        if(grid.get(0).get(0) == 1 || grid.get(grid.size()-1).get(grid.get(0).size()-1) == 1)
            return 0;
        Queue<int[]> que = new LinkedList<>();
        List<int[]> thvs = new ArrayList<>();
        boolean visited[][] = new boolean[grid.size()][grid.get(0).size()];
        for(int i=0;i<grid.size();i++) {
            for(int j=0;j<grid.get(0).size();j++) {
                if(grid.get(i).get(j) == 1) {
                    que.add(new int[]{i,j});
                    thvs.add(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }
        int count=0;
        while(!que.isEmpty()) {
            int len = que.size();
            for(int x=0;x<len;x++) {
                int i=que.peek()[0];
                int j=que.peek()[1];
                que.poll();
                grid.get(i).set(j, count);
                helper(i+1, j, que, grid, visited);
                helper(i, j+1, que, grid, visited);
                helper(i-1, j, que, grid, visited);
                helper(i, j-1, que, grid, visited);
            }
            count++;
        }
        for(boolean temp[]: visited)
            Arrays.fill(temp, false);
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        maxHeap.add(new int[]{grid.get(0).get(0), 0, 0});
        visited[0][0] = true;
        while(!maxHeap.isEmpty()) {
            int nodeVal=maxHeap.peek()[0];
            int i=maxHeap.peek()[1];
            int j=maxHeap.peek()[2];
            maxHeap.poll();            
            if(i == grid.size()-1 && j == grid.get(0).size()-1)
                return nodeVal;
            if(i+1 >= 0 && i+1 < grid.size() && !visited[i+1][j] && grid.get(i+1).get(j) != 0) {
                int temp = grid.get(i+1).get(j);
                temp = Math.min(temp, nodeVal);
                maxHeap.add(new int[]{temp, i+1, j});
                visited[i+1][j] = true;
            }
            if(j+1 >= 0 && j+1 < grid.get(0).size() && !visited[i][j+1] && grid.get(i).get(j+1) != 0) {
                int temp = grid.get(i).get(j+1);
                temp = Math.min(temp, nodeVal);
                maxHeap.add(new int[]{temp, i, j+1});
                visited[i][j+1] = true;
            }
            if(i-1 >= 0 && i-1 < grid.size() && !visited[i-1][j] && grid.get(i-1).get(j) != 0) {
                int temp = grid.get(i-1).get(j);
                temp = Math.min(temp, nodeVal);
                maxHeap.add(new int[]{temp, i-1, j});
                visited[i-1][j] = true;
            }
            if(j-1 >= 0 && j-1 < grid.get(0).size() && !visited[i][j-1] && grid.get(i).get(j-1) != 0) {
                int temp = grid.get(i).get(j-1);
                temp = Math.min(temp, nodeVal);
                maxHeap.add(new int[]{temp, i, j-1});
                visited[i][j-1] = true;
            }
        }
        return 0;
    }
    public void helper(int i, int j, Queue<int[]> que, List<List<Integer>> grid, boolean[][] visited) {
        if(i < 0 || j < 0 || i == grid.size() || j == grid.get(0).size() || visited[i][j])
            return;
        visited[i][j] = true;
        que.add(new int[]{i,j});
    }
}