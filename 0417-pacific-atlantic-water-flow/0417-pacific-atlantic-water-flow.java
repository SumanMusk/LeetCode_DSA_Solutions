class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ls = new ArrayList<>();      
        for(int i=0;i<heights.length;i++) {
            for(int j=0;j<heights[0].length;j++) {
                List<Integer> temp = new ArrayList<>();
                boolean visited[][] = new boolean[heights.length][heights[0].length];
                boolean x = pacificDFS(heights, i, j, visited);
                for(boolean q[]: visited) Arrays.fill(q, false);
                boolean y = atlanticDFS(heights, i, j, visited);
                if(x && y) {
                    temp.add(i);
                    temp.add(j);
                    ls.add(temp);
                }
            }
        }
        return ls;
    }
    public boolean pacificDFS(int arr[][], int i, int j, boolean[][] visited) {
        if(i == 0 || j == 0) return true;
        visited[i][j] = true;
        boolean chk = false;
        // top
        if(arr[i-1][j] <= arr[i][j] && !visited[i-1][j]) 
            chk = pacificDFS(arr, i-1, j, visited);
        // Right
        if(j+1 < arr[0].length && arr[i][j+1] <= arr[i][j] && !visited[i][j+1] && !chk) 
            chk = pacificDFS(arr, i, j+1, visited);
        // Bottom
        if(i+1 < arr.length && arr[i+1][j] <= arr[i][j] && !visited[i+1][j] && !chk) 
            chk = pacificDFS(arr, i+1, j, visited);
        // Left
        if(arr[i][j-1] <= arr[i][j] && !visited[i][j-1] && !chk)
            chk = pacificDFS(arr, i, j-1, visited);
        return chk;
    }
    public boolean atlanticDFS(int arr[][], int i, int j, boolean visited[][]) {
        if(i == arr.length-1 || j == arr[0].length-1) return true;
        visited[i][j] = true;
        boolean chk = false;
        // top
        if(i-1 >= 0 && arr[i-1][j] <= arr[i][j] && !visited[i-1][j]) 
            chk = atlanticDFS(arr, i-1, j, visited);
        // Right
        if(arr[i][j+1] <= arr[i][j] && !visited[i][j+1] && !chk) 
            chk = atlanticDFS(arr, i, j+1, visited);
        // Bottom
        if(arr[i+1][j] <= arr[i][j] && !visited[i+1][j] && !chk) 
            chk = atlanticDFS(arr, i+1, j, visited);
        // Left
        if(j-1 >= 0 && arr[i][j-1] <= arr[i][j] && !visited[i][j-1] && !chk)
            chk = atlanticDFS(arr, i, j-1, visited);
        return chk;
    }
}