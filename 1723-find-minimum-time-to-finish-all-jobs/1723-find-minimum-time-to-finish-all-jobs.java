class Solution {
    int res = Integer.MAX_VALUE;
    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        int[] sums = new int[k];
        dfs(jobs, jobs.length - 1, sums, k);
        return res;
    }
    
    private void dfs(int[] jobs, int curPos, int[] sums, int k) {
        if (curPos == -1) {
            res = Math.min(res, Arrays.stream(sums).max().getAsInt());
            return;
        }
        if (Arrays.stream(sums).max().getAsInt() >= res) return;
        for (int i = 0; i < k; i++) {
            if (i > 0 && sums[i] == sums[i - 1]) continue;
            sums[i] += jobs[curPos];
            dfs(jobs, curPos - 1, sums, k);
            sums[i] -= jobs[curPos];
        }
    }
}