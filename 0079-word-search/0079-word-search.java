class Solution {
    public boolean exist(char[][] board, String word) {
        boolean bool = false;        
        for(int i=0;i<board.length;i++){
            if(bool)
                break;
            for(int j=0;j<board[0].length;j++){
                if(word.charAt(0) == board[i][j]){
                    bool = wordSearch(board, word, i, j, 0);
                    if(bool)
                        break;
                }
            }
        }
        return bool;
    }
    public boolean wordSearch(char[][] board, String word, int x, int y, int idx){
        if(idx == word.length())
            return true;
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length)
            return false;
        boolean bool = false;
        if(board[x][y] == word.charAt(idx)){
            char temp = board[x][y];
            board[x][y] = '-';
            bool = wordSearch(board, word, x+1, y, idx+1);
            if(!bool)
                bool = wordSearch(board, word, x-1, y, idx+1);
            if(!bool)
                bool = wordSearch(board, word, x, y+1, idx+1);
            if(!bool)
                bool = wordSearch(board, word, x, y-1, idx+1);  
            board[x][y] = temp;
        }
        return bool;
    }
}