class Solution {
    public int orangesRotting(int[][] grid) {
        int count = 0;
        Queue<List<Integer>> que = new LinkedList<>();
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 2) {
                    List<Integer> ls = new ArrayList<>();
                    ls.add(i);
                    ls.add(j);
                    que.add(ls);
                }
            }
        }
        while(!que.isEmpty()) {
            int len = que.size();
            int f = 0;
            for(int x=0;x<len;x++) {
                List<Integer> temp = que.poll();
                int i = temp.get(0);
                int j = temp.get(1);
                if(i-1 >= 0 && grid[i-1][j] == 1) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i-1);
                    list.add(j);
                    que.add(list);
                    grid[i-1][j] = 2;
                    f = 1;
                }
                if(j+1 < grid[0].length && grid[i][j+1] == 1) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j+1);
                    que.add(list);
                    grid[i][j+1] = 2;
                    f = 1;
                }
                if(i+1 < grid.length && grid[i+1][j] == 1) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i+1);
                    list.add(j);
                    que.add(list);
                    grid[i+1][j] = 2;
                    f = 1;
                }
                if(j-1 >= 0 && grid[i][j-1] == 1) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j-1);
                    que.add(list);
                    grid[i][j-1] = 2;
                    f = 1;
                }
            }
            if(f == 1) count++;
        }
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 1) 
                    return -1;
            }
        }
        return count;
    }
}
/*
// For checking the directions, instead of checking all the edge cases in multiple if statements, we can simply create an "path" named 2D matrix and while iterate through the "path" matrix, we add those values and get the required Up-Right-Down-Left quardinates.
class Solution {
    public int orangesRotting(int[][] grid) {
        int count = 0;
        Queue<List<Integer>> que = new LinkedList<>();
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 2) {
                    List<Integer> ls = new ArrayList<>();
                    ls.add(i);
                    ls.add(j);
                    que.add(ls);
                }
            }
        }
        int paths[][] = {
            // top
            {-1,0},
            // right
            {0,1},
            // bottom
            {1,0},
            // left
            {0,-1},
        };
        while(!que.isEmpty()) {
            int len = que.size();
            int f = 0;
            for(int x=0;x<len;x++) {
                List<Integer> temp = que.poll();
                int i = temp.get(0);
                int j = temp.get(1);
                for(int dir[]: paths) {
                    int a = i + dir[0]; 
                    int b = j + dir[1];
                    if(a >= 0 && b >= 0 && a < grid.length && b < grid[0].length && grid[a][b] == 1) {
                        que.add(new ArrayList<>(Arrays.asList(a, b)));
                        grid[a][b] = 2;
                        f = 1;
                    }
                }
                if(i-1 >= 0 && grid[i-1][j] == 1) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i-1);
                    list.add(j);
                    que.add(list);
                    grid[i-1][j] = 2;
                    f = 1;
                }
            }
            if(f == 1) count++;
        }
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 1) 
                    return -1;
            }
        }
        return count;
    }
}
*/
/*
// we can further optimize the code by counting the number of fresh oranges into the grid and at last, if the count number isn't became zero, that means there is at least one fresh orange is remaining that cannot be transformed into a rotten one, so:
class Solution {
    public int orangesRotting(int[][] grid) {
        int count = 0, freshCount = 0;
        Queue<List<Integer>> que = new LinkedList<>();
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 2) {
                    List<Integer> ls = new ArrayList<>();
                    ls.add(i);
                    ls.add(j);
                    que.add(ls);
                }
                else if(grid[i][j] == 1) freshCount++;
            }
        }
        int paths[][] = {
            // top
            {-1,0},
            // right
            {0,1},
            // bottom
            {1,0},
            // left
            {0,-1},
        };
        while(!que.isEmpty() && freshCount > 0) {
            int len = que.size();
            int f = 0;
            for(int x=0;x<len;x++) {
                List<Integer> temp = que.poll();
                int i = temp.get(0);
                int j = temp.get(1);
                for(int dir[]: paths) {
                    int a = i + dir[0]; 
                    int b = j + dir[1];
                    if(a >= 0 && b >= 0 && a < grid.length && b < grid[0].length && grid[a][b] == 1) {
                        que.add(new ArrayList<>(Arrays.asList(a, b)));
                        grid[a][b] = 2;
                        freshCount--;
                        f = 1;
                    }
                }
            }
            if(f == 1) count++;
        }
        if(freshCount == 0) return count;
        return -1;
    }
}
*/