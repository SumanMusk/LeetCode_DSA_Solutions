class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int c=0;
        for(int i=0;i<grid.length-2;i++) 
            for(int j=0;j<grid[0].length-2;j++) 
                if(helper(grid, i, j))
                    c++;
        return c;
    }
    public boolean helper(int[][] grid, int row, int col) {
        Set<Integer> set = new HashSet<>();        
        int c=0;
        // Horizontally(rows)
        for(int i=row;i<=row+2;i++) {
            for(int j=col;j<=col+2;j++) {
                if(grid[i][j] > 0 && grid[i][j] <= 9 && !set.contains(grid[i][j])) {
                    set.add(grid[i][j]);
                    c += grid[i][j];
                }
                else
                    return false;
            }
            if(c != 15)
                return false;
            c=0;
        }
        // Vertically(columns)
        for(int i=col;i<=col+2;i++) {
            for(int j=row;j<=row+2;j++) 
                c += grid[j][i];
            if(c != 15)
                return false;
            c=0;
        }
        int i=row, j=col;
        // left to right Diagonal
        while(i <= row+2 && j <= col+2) 
            c += grid[i++][j++];
        if(c != 15)
            return false;
        c=0;
        i=row;
        j=col+2;
        // right to left Diagonal
        while(i <= row+2 && j >= col) 
            c += grid[i++][j--];
        if(c != 15)
            return false;
        return true;
    }
}