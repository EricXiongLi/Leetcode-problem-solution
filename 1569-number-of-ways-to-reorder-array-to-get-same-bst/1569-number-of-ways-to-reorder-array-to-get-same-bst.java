class Solution {
    Long[][] memo;
    int MOD = (int) 1e9 + 7;
    public int numOfWays(int[] nums) {
        List<Integer> list = new ArrayList<>();
        memo = new Long[nums.length][nums.length];
        for (int i : nums) list.add(i);
        long res = (MOD + totalWays(list) - 1) % MOD;
        return (int) res;
    }
    
    private long totalWays(List<Integer> list) {
        if (list.isEmpty()) return 1;
        List<Integer> l = new ArrayList<>();
        List<Integer> r = new ArrayList<>();
        int root = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < root) l.add(list.get(i));
            else r.add(list.get(i));
        }
        long leftWays = totalWays(l);
        long rightWays = totalWays(r);
        long prod = (leftWays * rightWays) % MOD;
        return (prod *  nCk(list.size() - 1, l.size())) % MOD;
    }
    
    private long nCk(int n, int k) {
        if (k == n || k == 0) {
            return 1;
        } 
        if (memo[n][k] != null) return memo[n][k];
        else {
            memo[n][k] = (nCk(n - 1, k) + nCk(n - 1, k - 1)) % MOD;
            return memo[n][k];
        }
    }
}