class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n = queries.length;
        int[] res = new int[n];
      Map<int[], Integer> hm = new HashMap<>(); // <int[], index of the array un queris>
      for (int i = 0; i < queries.length; i++) hm.put(queries[i], i);
      Arrays.sort(queries, (a, b) -> a[1] - b[1]);
      Arrays.sort(nums);
      int p = 0;
      TrieNode node = new TrieNode();
      int count = 0;
      for (int[] query: queries) {
        while (p <= nums.length - 1 && nums[p] <= query[1]) {
            node.addNum(node, nums[p]);
            count++;
          p++;
        }
        int pos = hm.get(query);
        if (count == 0) {
          res[pos] = -1;
        } else {
          int sum = node.findMaxXor(node, query[0]);
          res[pos] = sum;
        }
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
        for (int i = 31; i >= 0; i--) {
            int curBit = (num >> i) & 1;
            if (cur.children[curBit] == null) cur.children[curBit] = new TrieNode();
            cur = cur.children[curBit];
        }
    }
    
    public int findMaxXor(TrieNode root, int num) {
        TrieNode cur = root;
      int sum = 0;
      for (int i = 31; i >= 0; i--) {
        int curBit = (num >> i) & 1;
        int targetBit = curBit ^ 1;
        if (cur.children[targetBit] == null) {
          cur = cur.children[curBit];
        } else {
          cur = cur.children[targetBit];
          sum += (1 << i);
        }
      }
      return sum;
    }
}