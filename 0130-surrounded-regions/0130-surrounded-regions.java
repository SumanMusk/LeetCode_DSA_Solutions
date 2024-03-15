class Solution {
    public void solve(char[][] board) {
        // converting side 'O' into visited 'V'
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j] == 'O' && (i == 0 || j == 0 || i == board.length-1 || j == board[0].length-1)) {
                    convertDFS(board, i, j);
                }
            }
        }
        // converting inner 'O' elements into 'X'
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
        // reverting 'V' elements into 'O'
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j] == 'V')
                    board[i][j] = 'O';
            }
        }
    }
    public void convertDFS(char[][] board, int i, int j) {
        if(i < 0 || j < 0 || i > board.length-1 || j > board[0].length-1 || board[i][j] == 'X' || board[i][j] == 'V')
            return;
        board[i][j] = 'V';
        convertDFS(board, i-1, j);
        convertDFS(board, i, j+1);
        convertDFS(board, i+1, j);
        convertDFS(board, i, j-1);
    }
}