class Solution {
    public int minimumCost(int n, int[][] connections) {
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        DSU dsu = new DSU(n + 1);
        int count = 1;
        int totalCost = 0;
        for (int[] edge : connections) {
            int start = edge[0], end = edge[1], cost = edge[2];
            if (dsu.connected(start, end)) continue;
            dsu.union(start, end);
            totalCost += cost;
            count++;
        }
        return count == n ? totalCost : -1;
        
    }
}

class DSU {
    int[] parent;
    
    public DSU(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootX] = rootY;
        }
    }
    
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
    
}