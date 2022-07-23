class Solution {
    class TrieNode {
        boolean isEnd;
        TrieNode[] tns = new TrieNode[26];
    }
    
    TrieNode root = new TrieNode();
    
    void add(String s) {
        TrieNode p = root;
        for (int i = 0; i < s.length(); i++) {
            int pos = s.charAt(i) - 'a';
            if (p.tns[pos] == null) p.tns[pos] = new TrieNode();
            p = p.tns[pos];
        }
        p.isEnd = true;
    }
    
    boolean query(String s) {
        TrieNode p = root;
        for (int i = 0; i < s.length(); i++) {
            int pos = s.charAt(i) - 'a';
            if (p.tns[pos] == null || !p.tns[pos].isEnd) return false;
            p = p.tns[pos];
        }
        return true;
    }
    public String longestWord(String[] words) {
        String ans ="";
        for (String word: words) {
            add(word);
        }
        for (String word: words) {
            if ((word.length() == ans.length() && word.compareTo(ans) < 0 && query(word)) || (word.length() > ans.length() && query(word))) {
                ans = word;
            } 
        }
        return ans;
        
    }
}