class Solution {
    int MOD = (int)1e9+7;
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] l = new int[n], r = new int[n];
        Arrays.fill(l, -1); Arrays.fill(r, n);
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!d.isEmpty() && arr[d.peekLast()] >= arr[i]) r[d.pollLast()] = i;
            d.addLast(i);
        }
        d.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!d.isEmpty() && arr[d.peekLast()] > arr[i]) l[d.pollLast()] = i;
            d.addLast(i);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int a = l[i], b = r[i];
            ans += (i - a) * 1L * (b - i) % MOD * arr[i] % MOD;
            ans %= MOD;
        }
        return (int) ans;
    }
}