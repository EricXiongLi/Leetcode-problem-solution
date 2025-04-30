class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;

        int[][] job = new int[n][3];

        for (int i = 0; i < n; i++) {
            job[i][0] = startTime[i];
            job[i][1] = endTime[i];
            job[i][2] = profit[i];
        }

        Arrays.sort(job, (a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);
        int[] dp = new int[n];

        //dp[i] = Math.max(dp[i - 1], dp[j] + profit[i], where j is previous job)
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i] = job[i][2];
            } else {
                int j = findPrev(job, job[i][0], i);
                dp[i] = Math.max(dp[i - 1], job[i][2] + (j == -1 ? 0 : dp[j]));
            }
        }

        return dp[n - 1];
    }

    public int findPrev(int[][] job, int startTime, int i) {
        int l = 0, r = i;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (job[m][1] <= startTime) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return r;
    }
}

//<, <=, >
//l, m, r
//    r  lrm