class Solution {
    
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (arr[cur] == 0) return true;
            int lChild = cur - arr[cur];
            if (lChild >= 0 && !visited[lChild]) {
                visited[lChild] = true;
                q.offer(lChild);
            }
            int rChild = cur + arr[cur];
            if (rChild < arr.length && !visited[rChild]) {
                visited[rChild] = true;
                q.offer(rChild);
            }
        }
        return false;
    }
}