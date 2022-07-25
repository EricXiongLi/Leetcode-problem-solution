class Solution {
    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        for (int num : nums) {
            root.addNum(root, num);
        }
        int res = Integer.MIN_VALUE;
        for (int num : nums) {
            res = Math.max(root.findMaxXor(root, num), res);
        }
        return res;
    }
    
    
}

class TrieNode {
    TrieNode[] children;
    
    public TrieNode() {
        children = new TrieNode[2];
    }
    
    public void addNum(TrieNode root, int num) {
        TrieNode cur = root;
        for (int i = 30; i>= 0; i--) {
            int curBit = (num >> i) & 1;
            if (cur.children[curBit] == null) cur.children[curBit] = new TrieNode();
            cur = cur.children[curBit];
        }
    }
    
    public int findMaxXor(TrieNode root, int num) {
        int sum = 0;
        TrieNode cur = root;
        for (int i = 30; i >= 0; i--) {
            int curBit = (num >> i) & 1;
            int targetBit = curBit ^ 1;
            if (cur.children[targetBit] != null) {
                sum += (1 << i); // add 2 ^ i;
                cur = cur.children[targetBit];
            } else {
                cur = cur.children[curBit];
            }
        }
        return sum;
    }
}