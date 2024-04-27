class Node {
    char val;
    Node childArr[];
    boolean isWord;
    Node() {
        this.val = '*';
        this.childArr = new Node[26];
        this.isWord = false;
    }
    Node(char val) {
        this.val = val;
        this.childArr = new Node[26];
        this.isWord = false;
    }
}
class WordDictionary {
    Node root;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node curr = root;
        for(char letter: word.toCharArray()) {
            if(curr.childArr[letter-'a'] == null)
                curr.childArr[letter-'a'] = new Node(letter);
            curr = curr.childArr[letter-'a'];
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        return dfs(root, 0, word);
    }
    public boolean dfs(Node curr, int idx, String word) {
        if(idx == word.length()) 
            return curr.isWord;
        else if(Character.isAlphabetic(word.charAt(idx))) {
            if(curr.childArr[word.charAt(idx)-'a'] != null &&
               curr.childArr[word.charAt(idx)-'a'].val == word.charAt(idx))
                return dfs(curr.childArr[word.charAt(idx)-'a'], idx+1, word);
            else return false;
        }
        else if(word.charAt(idx) == '.'){
            for(int i=0;i<26;i++) 
                if(curr.childArr[i] != null && dfs(curr.childArr[i], idx+1, word))
                    return true;
            return false;
        }
        else return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */