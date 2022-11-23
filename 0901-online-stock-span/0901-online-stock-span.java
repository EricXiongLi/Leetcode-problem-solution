class StockSpanner {
    int count = 0;
    Deque<int[]> dq;
    //1,2 ,3 , 2, 1
    
    //3,  
    public StockSpanner() {
        dq = new ArrayDeque<>();
        dq.push(new int[]{Integer.MAX_VALUE, 0});
        count++;
    }
    
    public int next(int price) {
        while (!dq.isEmpty() && dq.peek()[0] <= price) {
            dq.pop();
        }
        int res = count - dq.peek()[1];
        dq.push(new int[]{price, count});
        count++;
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */