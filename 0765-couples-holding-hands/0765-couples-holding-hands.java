class Solution {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        int m = n/2;
        UnionFind uf = new UnionFind(m);
        for (int i = 0; i < n; i += 2) {
            uf.union(row[i]/2, row[i + 1]/2);
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            if (uf.find(i) == i) {
                res += (uf.size[i] - 1);
            }
        }
        
        return res;
    }
    
    class UnionFind {
        int[] parents;
        int[] size;
        public UnionFind(int n) {
            parents = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
            
            Arrays.fill(size, 1);
        }
        
        public int find(int x) {
            int parentX = parents[x];
            if (parentX != x) {
                parents[x] = find(parentX);
            }
            return parents[x];
        }
        
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (size[rootX] >= size[rootY]) {
                size[rootX] += size[rootY];
                parents[rootY] = rootX;
            } else {
                size[rootY] += size[rootX];
                parents[rootX] = rootY;
            }
            }
            
            
        }
    }
}