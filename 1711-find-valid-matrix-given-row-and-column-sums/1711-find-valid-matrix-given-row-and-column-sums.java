class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int mat[][] = new int[rowSum.length][colSum.length];
        for(int i=0;i<colSum.length;i++) {
            for(int j=0;j<rowSum.length;j++) {
                mat[j][i] = Math.min(colSum[i], rowSum[j]);
                colSum[i] -= mat[j][i];
                rowSum[j] -= mat[j][i];
            }
        }
        return mat;
    }
}