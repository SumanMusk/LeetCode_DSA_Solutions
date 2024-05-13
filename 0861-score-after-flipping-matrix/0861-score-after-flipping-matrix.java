class Solution {
    public int matrixScore(int[][] grid) {
        // converting whole rows by traversing each rows
        for(int i=0;i<grid.length;i++) {
            if(grid[i][0] == 0) {
                for(int j=0;j<grid[0].length;j++) {
                    if(grid[i][j] == 0)
                        grid[i][j] = 1;
                    else 
                        grid[i][j] = 0;
                }
            }
        }
        // converting cols based on the majority of 0's by traversing each cols
        for(int i=0;i<grid[0].length;i++) {
            int oneCount=0;
            for(int j=0;j<grid.length;j++) 
                if(grid[j][i] == 1)
                    oneCount++;
            if(oneCount <= grid.length/2) {
                for(int j=0;j<grid.length;j++) {
                    if(grid[j][i] == 0)
                        grid[j][i] = 1;
                    else 
                        grid[j][i] = 0;
                }
            }
        }
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) 
                System.out.print(grid[i][j]+" ");
            System.out.println();
        }
        int ans=0;
        for(int i=0;i<grid.length;i++) {
            String bnryDigt="";
            for(int j=0;j<grid[0].length;j++) 
                bnryDigt += String.valueOf(grid[i][j]);
            ans += Integer.parseInt(bnryDigt, 2);
        }
        return ans;
    }
}