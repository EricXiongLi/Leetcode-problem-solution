class StockSpanner {
    //decreasing stack
    //[index, price]
    Deque<int[]> stack = new LinkedList<>();
    int count = 0;
    public StockSpanner() {
        stack.push(new int[]{0, Integer.MAX_VALUE});
    }
    
    public int next(int price) {
        count++;
        while(!stack.isEmpty() && stack.peek()[1] <= price) {
            stack.pop();
        }
        int diff = count - stack.peek()[0];
        stack.push(new int[]{count, price});
        return diff;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */