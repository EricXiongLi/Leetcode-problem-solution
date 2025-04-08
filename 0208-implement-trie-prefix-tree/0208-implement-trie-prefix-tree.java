class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.tns[c - 'a'] == null) {
                cur.tns[c - 'a'] = new TrieNode();
            }
            cur = cur.tns[c - 'a'];
            if (i == word.length() - 1) {
                cur.isEnd = true;
            }
        }
    }
    
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.tns[c - 'a'] == null) {
                return false;
            }

            cur = cur.tns[c - 'a'];
            if (i == word.length() - 1) {
                return cur.isEnd;
            }
        }

        return true;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.tns[c - 'a'] == null) {
                return false;
            }
            cur = cur.tns[c - 'a'];
        }
        return true;
    }
}

class TrieNode {
    boolean isEnd;
    TrieNode[] tns;

    public TrieNode() {
        isEnd = false;
        tns = new TrieNode[26];
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */