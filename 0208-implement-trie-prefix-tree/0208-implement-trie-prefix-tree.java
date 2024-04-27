class Node {
    char val;
    Node childArr[];
    boolean isWord;
    Node() {
        this.val = '*';
        this.childArr = new Node[26];
        isWord = false;
    }
    Node(char val) {
        this.val = val;
        this.childArr = new Node[26];
        isWord = false;
    }
}

class Trie {
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;
        for(char letter: word.toCharArray()) {
            if(curr.childArr[letter - 'a'] == null)
                curr.childArr[letter - 'a'] = new Node(letter);
            curr = curr.childArr[letter - 'a'];
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        Node curr = root;
        for(char letter: word.toCharArray()) {
            if(curr.childArr[letter - 'a'] == null)
                return false;
            curr = curr.childArr[letter - 'a'];
        }
        return curr.isWord;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        for(char letter: prefix.toCharArray()) {
            if(curr.childArr[letter - 'a'] == null)
                return false;
            curr = curr.childArr[letter - 'a'];
        }
        return true;
    }
    
}
/*class Trie {
    List<String> ls;
    public Trie() {
        ls = new ArrayList<>();
    }
    
    public void insert(String word) {
        ls.add(word);
    }
    
    public boolean search(String word) {
        return ls.contains(word);
    }
    
    public boolean startsWith(String prefix) {
        for(String s: ls)
            if(s.length() >= prefix.length())
                if(s.substring(0, prefix.length()).equals(prefix))
                    return true;
        return false;
    }
}*/

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */