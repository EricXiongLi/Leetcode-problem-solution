class Solution {
    public int[] finalPrices(int[] prices) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = prices.length;
        //increasing stack
        //1, 2, 3, 4, 2
        Queue<Integer> res = new LinkedList<>();
        for (int i = n - 1; i >=0; i--) {
            while (!dq.isEmpty() && dq.peek() > prices[i]) {
                dq.pop();
            }
            int cur = dq.isEmpty() ? prices[i] : prices[i] - dq.peek();
            dq.push(prices[i]);
            res.offer(cur);
        }
        int[] ans = new int[res.size()];
    for (int i = 0; i < n; i++) {
        ans[n - 1 - i] = res.poll();
    }
    return ans;
    }
    
}