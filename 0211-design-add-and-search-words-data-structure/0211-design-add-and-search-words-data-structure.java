class WordDictionary {
    Trie trie;
    
    public WordDictionary() {
        trie = new Trie();
    }
    
    public void addWord(String word) {
        trie.insert(word);
    }
    
    public boolean search(String word) {
        return trie.search(word);
    }
}

class Trie {
    TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }
    
    boolean search(String word) {
        return dfs(word, 0, root);
    }
    
    boolean dfs(String word, int index, TrieNode r) {
        if (index == word.length()) {
            return r != null && r.isWord;
        }
         if (word.charAt(index) == '.') {
                for (int j = 0; j < 26; j++) {
                    if (r != null && dfs(word, index + 1, r.children[j])) {
                        return true;
                    }
                    
                }
             return false;
            } else {
                char c = word.charAt(index);
                if (r == null || r.children[c - 'a'] == null) return false;
                else {
                    return dfs(word, index + 1, r.children[c - 'a']);
                }
            }
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isWord;
    
    public TrieNode() {
        children = new TrieNode[26];
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */