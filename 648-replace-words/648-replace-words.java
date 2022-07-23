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
    
    String query(String s) {
        TrieNode p = root;
        for (int i = 0; i < s.length(); i++) {
            int pos = s.charAt(i) - 'a';
            if (p.tns[pos] == null) break;
            if (p.tns[pos].isEnd) return s.substring(0, i + 1);
            p = p.tns[pos];
        }
        return s;
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        for (String s: dictionary) {
            add(s);
        }
        StringBuilder sb = new StringBuilder();
        String[] sArr = sentence.split(" ");
        for (int i = 0; i < sArr.length; i++) {
            sb.append(query(sArr[i]));
            if (i != sArr.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
        
    }
}