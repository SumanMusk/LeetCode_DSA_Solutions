class Solution {
    public void setZeroes(int[][] matrix) {
        boolean visited[][] = new boolean[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix[0].length;j++)
                if(matrix[i][j] == 0)
                    helper(i, j, matrix, visited);
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix[0].length;j++)
                if(visited[i][j])
                    matrix[i][j] = 0;
    }
    public void helper(int i, int j, int[][] arr, boolean[][] visited) {
        // vertically
        for(int x=0;x<arr.length;x++)
            if(arr[x][j] != 0)
                visited[x][j] = true;
        // horizontally
        for(int x=0;x<arr[0].length;x++)
            if(arr[i][x] != 0)
                visited[i][x] = true;
    }
}