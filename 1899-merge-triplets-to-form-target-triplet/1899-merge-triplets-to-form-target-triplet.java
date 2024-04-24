class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean bool[] = new boolean[triplets.length];
        for(int x=0;x<triplets.length;x++) 
            for(int i=0;i<target.length;i++) 
                if(triplets[x][i] > target[i])
                    bool[x] = true;

        for(int i=0;i<target.length;i++) {
            int f=0; 
            for(int j=0;j<triplets.length;j++) {
                if(bool[j]) continue;
                if(target[i] == triplets[j][i])
                    f=1;
            }
            if(f == 0) return false;
        }
        return true;
    }
}