class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
         Map<Integer, Integer> map = new HashMap<>();
        DSU dsu = new DSU(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) continue;
            int greater = nums[i] + 1;
            int smaller = nums[i] - 1;
            if (map.containsKey(greater)) {
                dsu.union(i, map.get(greater));
            }
            if (map.containsKey(smaller)) {
                dsu.union(i, map.get(smaller));
            }
            map.put(nums[i], i);
        }
        
        return dsu.findMax();
    }
        
        
}


class DSU {
    int[] parent;
    int[] size;
    
    public DSU(int n) {
        parent = new int[n];
        size = new int[n];
        Arrays.fill(size, 1);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    
    public int find(int x) {
        int parentX = parent[x];
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        } 
        return parent[x];
    }
    
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) return;
        if (size[rootX] > size[rootY]) {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        } else {
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        }
    }
    
    public int findMax() {
        int max = 1;
        for (int i : size) {
            max = Math.max(i, max);
        }
        return max;
    }
    
}
