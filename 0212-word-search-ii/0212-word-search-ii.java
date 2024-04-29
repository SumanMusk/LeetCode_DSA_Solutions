class node {
    char val;
    node childArr[];
    boolean isWord;
    node() {
        this('*');
    }
    node(char val) {
        this.val = val;
        this.childArr = new node[26];
        isWord = false;
    }
}
class Solution {
    node root;
    Solution() {
        root = new node();
    }
    public List<String> findWords(char[][] board, String[] words) {
        for(String s: words)
            addWord(s);
        Set<String> res = new HashSet<>();
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) 
                helperDfs(i, j, "", board, res, root);
        }
        return new ArrayList<>(res);
    }
    public void helperDfs(int r, int c, String word, char[][] board, Set<String> res, node root) {
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length)
            return;
        else if(board[r][c] == '-') return;
        else if(root.childArr[board[r][c]-'a'] == null) return;
        root = root.childArr[board[r][c]-'a'];
        word += board[r][c];
        if(root.isWord) {
            root.isWord = false;
            res.add(word);
        }
        char temp = board[r][c];
        board[r][c] = '-';
        helperDfs(r+1, c, word, board, res, root);
        helperDfs(r, c+1, word, board, res, root);
        helperDfs(r-1, c, word, board, res, root);
        helperDfs(r, c-1, word, board, res, root);
        board[r][c] = temp;
    }
    public void addWord(String word) {
        node curr = root;
        for(char c: word.toCharArray()) {
            if(curr.childArr[c-'a'] == null)
                curr.childArr[c-'a'] = new node(c);
            curr = curr.childArr[c-'a'];
        }
        curr.isWord = true;
    }
}