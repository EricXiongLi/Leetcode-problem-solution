class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.nodes[c - 'a'] == null) {
                cur.nodes[c - 'a'] = new TrieNode();
            }
            cur = cur.nodes[c - 'a'];
            if (i == word.length() - 1) {
                cur.isEnd = true;
            }
        }
    }
    
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.nodes[c - 'a'] == null) return false;
            cur = cur.nodes[c - 'a'];
            if (i == word.length() - 1 && cur.isEnd == false) {
                return false;
            }
        }
        return true;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);

            if (cur.nodes[c - 'a'] == null) {
                return false;
            }
            cur = cur.nodes[c - 'a'];
        }

        return true;
    }
}

class TrieNode {
    TrieNode[] nodes;
    boolean isEnd;

    public TrieNode() {
        nodes = new TrieNode[26];
        isEnd = false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */