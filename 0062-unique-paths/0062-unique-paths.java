class Solution {
    public int uniquePaths(int m, int n) {
        int arr[][] = new int[m+1][n+1];
        arr[m-1][n-1] = 1;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i == m-1 && j == n-1) continue;
                else arr[i][j] = arr[i+1][j] + arr[i][j+1];
            }
        }
        return arr[0][0];
    }
}