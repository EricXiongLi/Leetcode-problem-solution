class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        List<int[]> edges = new ArrayList<int[]>(); //start, end, cost
        for (int i = 1; i <= n; i++) {
            edges.add(new int[]{0, i, wells[i - 1]});
        }
        for (int[] pipe: pipes) {
            edges.add(pipe);
        }
        Collections.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
        DSU dsu = new DSU(n + 1);
        int totalCost = 0;
        for (int[] edge : edges) {
            int start = edge[0], end = edge[1], cost = edge[2];
            if (dsu.connected(start, end)) continue;
            dsu.union(start, end);
            totalCost += cost;
        }
        return totalCost;
    }
}

class DSU {
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
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    public void union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX == rootY) return;
        if (size[rootX] >= size[rootY]) {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        } else {
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        }
    }
    
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}