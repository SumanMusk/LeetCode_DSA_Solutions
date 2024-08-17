class Solution {
    public long maxPoints(int[][] points) {
        long prev_Row[] = new long[points[0].length];
        for(int i=0;i<points[0].length;i++) 
            prev_Row[i] = points[0][i];
        for(int i=1;i<points.length;i++) {
            long[] tempArr = new long[points[0].length];
            long[] left = new long[points[0].length];
            long[] right = new long[points[0].length];

            left[0] = prev_Row[0];
            right[right.length-1] = prev_Row[prev_Row.length-1];
            
            for(int j=1;j<points[0].length;j++) 
                left[j] = Math.max(left[j-1]-1, prev_Row[j]);
            
            for(int j=points[0].length-2;j>=0;j--) 
                right[j] = Math.max(right[j+1]-1, prev_Row[j]);

            for(int j=0;j<points[0].length;j++) 
                tempArr[j] = points[i][j] + Math.max(left[j], right[j]);

            prev_Row = Arrays.copyOf(tempArr, points[i].length);
            for(long g: prev_Row)
                System.out.print(g+" ");
        }
        long res=0;
        for(long i: prev_Row) 
            res = Math.max(res, i);
        return res;
    }
}
