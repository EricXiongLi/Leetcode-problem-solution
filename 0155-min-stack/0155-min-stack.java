class MinStack {
    //[cur, currentMin]
    Deque<int[]> dq;
    public MinStack() {
        dq = new ArrayDeque<>();
    }
    
    public void push(int val) {
        if (dq.isEmpty()) {
            dq.push(new int[]{val, val});
            return;
        }
        int[] top = dq.peek();
        int curMin = Math.min(val, top[1]);
        dq.push(new int[]{val, curMin});
    }
    
    public void pop() {
        dq.pop();
    }
    
    public int top() {
        return dq.peek()[0];
    }
    
    public int getMin() {
        return dq.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */