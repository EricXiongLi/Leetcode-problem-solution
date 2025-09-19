class MinStack {
    //[val, count], decreasing stack
    Deque<int[]> dq = new ArrayDeque<>();
    Deque<Integer> stack = new ArrayDeque<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        stack.push(val);
        if (dq.isEmpty()) {
            dq.push(new int[]{val, 1});
        } else {
            if (dq.peek()[0] == val) {
                dq.peek()[1]++;
            } else if (dq.peek()[0] > val) {
                dq.push(new int[]{val, 1});
            }
        }
    }
    
    public void pop() {
        int val = stack.pop();
        if (val == dq.peek()[0]) {
            dq.peek()[1]--;
            if(dq.peek()[1] == 0) {
                dq.pop();
            }
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return dq.peek()[0];
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