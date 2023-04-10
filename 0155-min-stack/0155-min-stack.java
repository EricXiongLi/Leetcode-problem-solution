class MinStack {
    Deque<Integer> dq1;
    Deque<Integer> dq2;
    
    public MinStack() {
        dq1 = new ArrayDeque<>();
        dq2 = new ArrayDeque<>();
    }
    
    public void push(int val) {
        dq1.push(val);
        if (dq2.isEmpty()) {
            dq2.push(val);
        } else {
            if (val <= dq2.peek()) {
                dq2.push(val);
            }
        }
        
    }
    
    public void pop() {
        int val = dq1.pop();
        if (val == dq2.peek()) {
            dq2.pop();
        }
        
    }
    
    public int top() {
        return dq1.peek();
    }
    
    public int getMin() {
        return dq2.peek();
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