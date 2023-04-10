class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) node.children[c - 'a'] = new TrieNode();
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }
    
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }
    
    public boolean searchHelper(String word, int pos, TrieNode root) {
        if (pos == word.length()) return root.isWord;
        char c = word.charAt(pos);
        if (c != '.') {
            if (root.children[c - 'a'] != null && searchHelper(word, pos + 1, root.children[c - 'a'])) {
                return true;
            } else {
                return false;
            }
        } else {
            for (int i = 0; i < 26; i++) {
                if (root.children[i] != null && searchHelper(word, pos + 1, root.children[i])) {
                    return true;
                }
            }
            return false;
        }
    } 
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

class TrieNode {
    TrieNode[] children;
    boolean isWord;
    
    public TrieNode() {
        children = new TrieNode[26];
    }
}