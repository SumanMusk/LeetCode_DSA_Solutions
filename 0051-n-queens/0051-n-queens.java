class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ls = new ArrayList<>();
        char board[][] = new char[n][n];
        for(int i=0;i<board.length;i++)
            Arrays.fill(board[i], '.');
        niggaQueens(ls, board, n, 0);
        return ls;
    }
    public void niggaQueens(List<List<String>> ls, char[][] board, int n, int idx){
        if(idx == n){
            String str = "";
            List<String> temp = new ArrayList<>();
            for(int x=0;x<board.length;x++){
                for(int y=0;y<board[0].length;y++)
                    str += Character.toString(board[x][y]);
                temp.add(str);
                str = "";
            }
            ls.add(temp);
            return;
        }
        else{
            for(int i=0;i<n;i++){
                board[idx][i] = 'Q';
                if(isSafe(idx, i, board))
                    niggaQueens(ls, board, n, idx+1);
                board[idx][i] = '.';
            }
        }
    }
    public boolean isSafe(int i, int j, char[][] board){
        int x = i-1;
        int y = j-1;
        int f=0;
        // left diagonal
        while(y>=0 && x>=0){
            if(board[x][y] == 'Q'){
                f=1;
                break;
            }
            x--;
            y--;
        }
        x = i-1;
        y = j+1;
        // right diagonal
        while(y<board[0].length && x>=0 && f == 0){
            if(board[x][y] == 'Q'){
                f=1;
                break;
            }
            x--;
            y++;
        }
        x = i-1;
        y = j;
        // vertically
        while(x>=0 && f == 0){
            if(board[x][y] == 'Q'){
                f=1;
                break;
            }
            x--;
        }
        if(f == 1) return false;
        return true;
    }
}