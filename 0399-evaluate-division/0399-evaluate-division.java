class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        
        UnionFind uf = new UnionFind();
        
        for (int i = 0; i < n; i++) {
            List<String> equation = equations.get(i);
            
            uf.add(equation.get(0));
            uf.add(equation.get(1));
            uf.union(equation.get(0), equation.get(1), values[i]);
        }
        int n2 = queries.size();
        double[] res = new double[n2];
        for (int i = 0; i < n2; i++) {
            List<String> query = queries.get(i);
            String a = query.get(0), b = query.get(1);
            if (!uf.isConnected(a, b)) {
                res[i] = -1;
            } else {
                res[i] = uf.values.get(a) / uf.values.get(b);
            }
        }
        
        return res;
    }
    
    class UnionFind {
        Map<String, String> parents;
        Map<String, Double> values;
        
        public UnionFind() {
            parents = new HashMap<>();
            values = new HashMap<>();
        }
        
        public String find(String x) {
            String parentX = parents.get(x);
            if (!parentX.equals(x)) {
                parents.put(x, find(parentX));
                values.put(x, values.get(x) * values.get(parentX));
            }
            return parents.get(x);
        }
        
        public void union(String x, String y, double val) {
            String rootX = find(x);
            String rootY = find(y);
            
            if (rootX != rootY) {
                parents.put(rootX, rootY);
                values.put(rootX, val * values.get(y) / values.get(x));
            }
        }
        
        public boolean isConnected(String x, String y) {
            return values.containsKey(x) && values.containsKey(y) && find(x).equals(find(y));
        }
        
        public void add(String s) {
            if (!parents.containsKey(s)) {
                parents.put(s, s);
                values.put(s, 1.0);
            }
        }
    }
}