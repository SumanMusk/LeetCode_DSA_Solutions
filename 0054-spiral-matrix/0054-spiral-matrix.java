class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ls = new ArrayList<>();
        int T=0, L=0, R=matrix[0].length-1, B=matrix.length-1;
        while(L <= R && T <= B) {
            for(int x=L;x<=R;x++) 
                ls.add(matrix[T][x]);
            T++;
            for(int x=T;x<=B;x++) 
                ls.add(matrix[x][R]);
            R--;
            if(T<=B)
                for(int x=R;x>=L;x--) 
                    ls.add(matrix[B][x]);
            B--;
            if(L<=R)
                for(int x=B;x>=T;x--) 
                    ls.add(matrix[x][L]);
            L++;
        }
        return ls;
    }    
}