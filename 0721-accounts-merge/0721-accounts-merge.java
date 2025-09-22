class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //email to #
        Map<String, Integer> emailsMap = new HashMap<>();
        //# to name
        Map<Integer, String> namesMap = new HashMap<>();
        DSU dsu = new DSU(accounts.size());

        for (int i = 0; i < accounts.size(); i++) {
            namesMap.put(i, accounts.get(i).get(0));
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);

                if (emailsMap.containsKey(email)) {
                    dsu.union(i, emailsMap.get(email));
                } else {
                    emailsMap.put(email, i);
                }
            }
        }

        Map<Integer, Set<String>> allEmailsMap = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++) {
            int root = dsu.find(i);
            if (!allEmailsMap.containsKey(root)) {
                allEmailsMap.put(root, new HashSet<String>());
            }
            for (int j = 1; j < accounts.get(i).size(); j++) {
                allEmailsMap.get(root).add(accounts.get(i).get(j));
            }
        }

        List<List<String>> res = new LinkedList<>();

        for (int key : allEmailsMap.keySet()) {
            List<String> cur = new LinkedList<>();
            cur.add(namesMap.get(key));
            List<String> emails = new ArrayList<>(allEmailsMap.get(key));
            Collections.sort(emails);
            cur.addAll(emails);
            res.add(cur);
        }

        return res;
        
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
        int parentX = parent[x];

        if (x != parentX) {
            parent[x] = find(parentX);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX == rootY) return;
        if (size[rootX] <= size[rootY]) {
            size[rootY] += size[rootX];
            parent[rootX] = rootY;
        } else if (size[rootX] > size[rootY]) {
            size[rootX] += size[rootY];
            parent[rootY] = rootX;
        }
    }
}