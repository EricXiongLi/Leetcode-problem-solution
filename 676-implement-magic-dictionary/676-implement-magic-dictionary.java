class MagicDictionary {
    class TrieNode {
        boolean isEnd;
        TrieNode[] tns = new TrieNode[26];
    }
    
    TrieNode root;
    
    void add(String s) {
        TrieNode p = root;
        for (int i = 0; i < s.length(); i++) {
            int pos = s.charAt(i) - 'a';
            if (p.tns[pos] == null) p.tns[pos] = new TrieNode();
            p = p.tns[pos];
        }
        p.isEnd = true;
    }
    
    public MagicDictionary() {
        root = new TrieNode();
    }
    
    
    
    public void buildDict(String[] dict) {
        for (String s: dict) {
            add(s);
        }
    }
    
    public boolean search(String word) {
        return dfs(word, 0, 1, root);
    }
    
    boolean dfs(String word, int index, int timesLeft, TrieNode root) {
        if (timesLeft == 0) {
            TrieNode p = root;
            for (int i = index; i < word.length(); i++) {
                int pos = word.charAt(i) - 'a';
                if (p.tns[pos] == null) return false;
                p = p.tns[pos];
            }
            return p.isEnd;
        }
        //case 1: index is not the end
        if (index != word.length() - 1) {
            TrieNode p = root;
            int pos = word.charAt(index) - 'a';
            //option1: not switch
            if (root.tns[pos] != null) {
                if (dfs(word, index + 1, timesLeft, root.tns[pos])) return true;
            }
            
            //option2: switch
            
            for (int i = 0; i < 26; i++) {
                if (i != pos) {
                    if (root.tns[i] != null && dfs(word, index + 1, timesLeft - 1, root.tns[i])) return true;
                }
            }
            
           
        } 
        
        //case 2: index is the end
        else {
            int pos = word.charAt(index) - 'a';
            for (int i = 0; i < 26; i++) {
                if (i != pos) {
                    if (root.tns[i] != null && root.tns[i].isEnd) return true;
                }
            }
        }
        
         return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */