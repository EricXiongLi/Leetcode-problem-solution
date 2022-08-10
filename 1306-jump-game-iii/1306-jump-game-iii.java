class Solution {
    
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return dfs(arr, start, visited);
    }
    
    private boolean dfs(int[] arr, int pos, boolean[] visited) {
        if (pos < 0 || pos >= arr.length || visited[pos]) {
            return false;
        }
        if (arr[pos] == 0) return true;
        visited[pos] = true;
        return dfs(arr, pos + arr[pos], visited) || dfs(arr, pos - arr[pos], visited);
    }
}