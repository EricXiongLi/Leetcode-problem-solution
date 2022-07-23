class MapSum {
    class TrieNode {
        boolean isEnd;
        int val;
        TrieNode[] tns = new TrieNode[26];
    }
    
    TrieNode root;
    int sum;
    
    public MapSum() {
        root = new TrieNode();
        sum = 0;
    }
    
    public void insert(String key, int val) {
        TrieNode p = root;
        for (int i = 0; i < key.length(); i++) {
            int pos = key.charAt(i) - 'a';
            if (p.tns[pos] == null) p.tns[pos] = new TrieNode();
            p = p.tns[pos];
        }
        p.isEnd = true;
        p.val = val;
    }
    
    public int sum(String prefix) {
        TrieNode p = root;
        for (int i = 0; i < prefix.length(); i++) {
            int pos = prefix.charAt(i) - 'a';
            if (p.tns[pos] == null) return 0;
            p = p.tns[pos];
        }
        dfs(p);
        int ans = sum;
        sum = 0;
        return ans;
    }
    
    private void dfs(TrieNode root) {
        //base case
        if (root == null) return;
        
        if (root.isEnd) sum += root.val;
        for (int i = 0; i < 26; i++) {
            if (root.tns[i] != null) {
                dfs(root.tns[i]);
            }
        }
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */