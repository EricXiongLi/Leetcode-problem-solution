class TrieNode {
    boolean end;
    TrieNode[] tns = new TrieNode[26];
    
}

class Trie {
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode(); 
    }
    
    public void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (p.tns[pos] == null) p.tns[pos] = new TrieNode();
            p = p.tns[pos];
        }
        p.end = true;
    }
    
    public boolean search(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (p.tns[pos] == null) return false;
            p = p.tns[pos];
        }
        return p.end;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (int i = 0; i < prefix.length(); i++) {
            int pos = prefix.charAt(i) - 'a';
            if (p.tns[pos] == null) return false;
            p = p.tns[pos];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */