class Solution {
    //[3, 1, 2, 4]
    //1 : l[1] = -1  r[1] = -1 => 1 * 1
    //left + 1... i, ... right - 1
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int MOD = (int) 1e9 + 7;
        int[] l = new int[n], r = new int[n];
        Arrays.fill(l, -1);
        Arrays.fill(r, n);
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (dq.isEmpty()) {
                dq.offer(i);
            } else {
                while (!dq.isEmpty() && arr[dq.peekLast()] >= arr[i]) {
                    dq.pollLast();
                }
                l[i] = dq.isEmpty() ? -1 : dq.peekLast();
                dq.offer(i);
            }
        }
        System.out.println(Arrays.toString(l));
        dq.clear();
        for (int i = n - 1; i >= 0; i--) {
            if (dq.isEmpty()) {
                dq.offer(i);
            } else {
                while (!dq.isEmpty() && arr[dq.peekLast()] > arr[i]) {
                    dq.pollLast();
                }
                r[i] = dq.isEmpty() ? n : dq.peekLast();
                dq.offer(i);
            }
        }
        System.out.println(Arrays.toString(r));
        long res = 0;
        for (int i = 0; i < n; i++) {
            int left = l[i], right = r[i];
            int leftNum =  i - (left + 1) + 1;
            int rightNum = right - 1 - i + 1;
            res += arr[i] * 1L * leftNum % MOD * rightNum % MOD;
            res = res % MOD;
        }
        return (int)res;
    }
}