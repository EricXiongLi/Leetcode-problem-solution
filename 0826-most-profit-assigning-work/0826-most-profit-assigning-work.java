class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<int[]> jobs = new ArrayList();
        for (int i = 0; i < profit.length; i++) {
            jobs.add(new int[]{difficulty[i], profit[i]});
        }

        Collections.sort(jobs, (a, b) -> a[0] - b[0]);
        Arrays.sort(worker);

        int p1 = 0;
        int p2 = 0;
        int res = 0;
        int curMaxProfit = 0;
        while (p2 < worker.length) {
            while (p1 < profit.length && jobs.get(p1)[0] <= worker[p2]) {
                curMaxProfit = Math.max(jobs.get(p1)[1], curMaxProfit);
                p1++;
            }
            res += curMaxProfit;
            p2++;
        }
        return res;
    }
}