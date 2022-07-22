class TrieNode {
    boolean end;
    TrieNode[] tns =new TrieNode[26];
}
class WordDictionary {
    
    private TrieNode root;
    

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (p.tns[pos] == null) p.tns[pos] = new TrieNode();
            p = p.tns[pos];
        }
        p.end = true;
    }
    
    public boolean search(String word) {
      return dfs(word, root, 0);
    }
    
    private boolean dfs(String word, TrieNode root, int index) {
        if (index == word.length()) {
            return root != null && root.end;
        }
        if (word.charAt(index) == '.') {
            for (int i = 0; i < 26; i++) {
                if (root != null && dfs(word, root.tns[i], index + 1)) return true;
            }
            return false;
        } else {
            int pos = word.charAt(index) - 'a';
            if (root == null || root.tns[pos] == null) return false;
            else {
                return dfs(word, root.tns[pos], index + 1);
            }
        }
        
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */