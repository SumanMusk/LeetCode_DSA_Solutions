class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ls = new ArrayList<>();
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                int minVal = Integer.MAX_VALUE;
                int maxVal = Integer.MIN_VALUE;
                for(int col=0;col<matrix.length;col++) 
                    maxVal = Math.max(maxVal, matrix[col][j]);
                for(int row=0;row<matrix[0].length;row++) 
                    minVal = Math.min(minVal, matrix[i][row]);
                if(maxVal == minVal)
                    ls.add(maxVal);
            }
        }
        return ls;
    }
}