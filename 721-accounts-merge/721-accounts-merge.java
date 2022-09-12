class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<Integer, Set<String>> idToEmails = new HashMap<>();
        Map<String, Integer> emailToId = new HashMap<>();
        int size = accounts.size();
        DSU dsu = new DSU(size);
        for (int i = 0; i < size; i++) {
            List<String> list = accounts.get(i);
            for (int j = 1; j < list.size(); j++) {
                String email = list.get(j);
                idToEmails.computeIfAbsent(i, v -> new HashSet<String>()).add(list.get(j));
                if (emailToId.containsKey(email)) {
                    int oldId = emailToId.get(email);
                    dsu.union(oldId, i);
                }
                emailToId.put(list.get(j), i);
            }
        }
        
        for (int i = 0; i < size; i++) {
            int parent = dsu.find(i);
            if (parent != i) {
                Set<String> rootEmails = idToEmails.get(parent);
                rootEmails.addAll(idToEmails.get(i));
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        
        for (int i = 0; i < size; i++) {
            int parent = dsu.find(i);
            String name = accounts.get(i).get(0);
            if (parent == i) {
                List<String> emails = new ArrayList<>(idToEmails.get(i));
                Collections.sort(emails);
                emails.add(0, name);
                res.add(emails);
            }
        }
        return res;
    }
}

class DSU {
    int[] parent;
    int[] size;
    
    public DSU (int n) {
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
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) return;
        if (size[rootX] < size[rootY]) {
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        } else {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        }
    }
}