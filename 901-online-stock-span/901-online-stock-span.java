class StockSpanner {
    Deque<int[]> stack = new ArrayDeque<>(); //[val, index], decreasing
    int count;
    public StockSpanner() {
        stack = new ArrayDeque<>();
        stack.push(new int[]{Integer.MAX_VALUE, 0});
        count = 0;
    }
    
    public int next(int price) {
        int res;
        if (stack.isEmpty()) {
            count = count + 1;
            res = count - stack.peek()[1];
            stack.push(new int[]{price, count});
        } else {
            while (!stack.isEmpty() && stack.peek()[0] <= price) {
                stack.pop();
            }
            count = count + 1;
            res = count - stack.peek()[1];
            stack.push(new int[]{price, count});
        }
        return res;
    }
    
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */