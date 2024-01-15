class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        DSU dsu = new DSU(n);
        
        for (int i = 0; i < n; i++) {
            for (int nei : graph[i]) {
                if (dsu.isConnected(i, nei)) {
                    return false;
                }
                dsu.union(nei, graph[i][0]);
            }
        }
        return true;
    }
    
}

public class DSU {
    int[] parent;
    int[] size;
    
    public DSU(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Arrays.fill(size, 1);
    }
    
    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }
    
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if (rootX < rootY) {
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        } else {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        }
    }
    
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}