class Solution {
    public int regionsBySlashes(String[] grid) {
        int mat[][] = new int[grid.length * 3][grid.length * 3];
        int row=0, col=0;
        for(String s: grid) {
            for(char c: s.toCharArray()) {
                if(Character.toString(c).equals("\\")) {
                    int i=row, j=col;
                    while(i < row+3 && j < col+3) 
                        mat[i++][j++] = 1;
                }
                if(Character.toString(c).equals("/")) {
                    int i=row, j=col+2;
                    while(i < row+3 && j >= col) 
                        mat[i++][j--] = 1;
                }
                col += 3;
                if(col >= mat[0].length) {
                    row += 3;
                    col = 0;
                }
            }
        }
        int res=0;
        for(int i=0;i<mat.length;i++) {
            for(int j=0;j<mat[0].length;j++) {
                if(mat[i][j] == 0) {
                    helperDFS(mat, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    public void helperDFS(int mat[][], int i, int j) {
        if(i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || mat[i][j] == 1)
            return;
        mat[i][j] = 1;
        helperDFS(mat, i+1, j);
        helperDFS(mat, i, j+1);
        helperDFS(mat, i-1, j);
        helperDFS(mat, i, j-1);
    }
}