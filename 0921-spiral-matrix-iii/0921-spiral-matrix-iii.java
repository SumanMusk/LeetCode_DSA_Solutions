class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int res[][] = new int[rows * cols][2];
        int c=0;
        res[c++] = new int[]{rStart, cStart};
        int hori_bound=1, verti_bound=1;
        while(c < res.length) {
            // right
            for(int i=0;i<hori_bound;i++) {
                cStart++;
                if(rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols && c < res.length)
                    res[c++] = new int[]{rStart, cStart};
            }
            // down
            for(int i=0;i<verti_bound;i++) {
                rStart++;
                if(rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols && c < res.length)
                    res[c++] = new int[]{rStart, cStart};
            }
            hori_bound++;
            verti_bound++;
            // left
            for(int i=0;i<hori_bound;i++) {
                cStart--;
                if(rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols && c < res.length)
                    res[c++] = new int[]{rStart, cStart};
            }
            // up
            for(int i=0;i<verti_bound;i++) {
                rStart--;
                if(rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols && c < res.length)
                    res[c++] = new int[]{rStart, cStart};
            }
            hori_bound++;
            verti_bound++;
        }
        return res;
    }
}