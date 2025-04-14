class Solution {
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        for (int[] edge : edges) {
            dsu.union(edge[0], edge[1]);
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (dsu.find(i) == i) {
                count++;
            }
        }

        return count;
    }

    public class DSU {
        public int[] parents;
        public int N;
        public int[] size;

        public DSU(int N) {
            this.N = N;
            size = new int[N];
            parents = new int[N];
            for (int i = 0; i < N; i++) {
                parents[i] = i;
            }

            Arrays.fill(size, 1);
        }

        public int find(int x) {
            if (parents[x] != x) {
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return;
            if (size[rootX] < size[rootY]) {
                parents[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                parents[rootY] = rootX;
                size[rootX] += size[rootY];
            }
        }
    }
}