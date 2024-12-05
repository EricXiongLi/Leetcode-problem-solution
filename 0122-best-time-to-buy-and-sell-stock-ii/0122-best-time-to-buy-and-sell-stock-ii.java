class Solution {
    public int maxProfit(int[] prices) {
        Deque<int[]> stack = new ArrayDeque<>();
        int res = 0;
        //monotonic increasing stack
        for (int i = 0; i < prices.length; i++) {
            if (!stack.isEmpty() && stack.peek()[1] < prices[i]) {
                res += prices[i] - stack.peek()[1];
            }
            while (!stack.isEmpty() && stack.peek()[1] >= prices[i]) {
                stack.pop();
            }
            
            stack.push(new int[]{i, prices[i]});
        }
        
        return res;
    }
}