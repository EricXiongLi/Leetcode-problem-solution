class Solution {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>(); //<val, index the val appears>
        for (int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i], v -> new ArrayList<Integer>()).add(i);
        }
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        boolean[] visited = new boolean[arr.length];
        int step = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int cur = q.poll();
                if (cur == arr.length - 1) return step;
                int lChild = cur - 1;
                int rChild = cur + 1;
                if (lChild >= 0 && !visited[lChild]) {
                    q.offer(lChild);
                    visited[lChild] = true;
                }
                if (rChild < arr.length && !visited[rChild]) {
                    q.offer(rChild);
                    visited[rChild] = true;
                }
                for (int j : map.getOrDefault(arr[cur], new ArrayList<Integer>())) {
                    if (j != cur && !visited[j]) {
                        visited[j] = true;
                        q.offer(j);
                    }
                }
                map.remove(arr[cur]);
            }
            step++;
        }
        return step;
    }
}