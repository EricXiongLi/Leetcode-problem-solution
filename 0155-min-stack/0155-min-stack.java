class MinStack {
    Deque<Integer> stack1, stack2;

    public MinStack() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack1.push(val);
        if (stack2.isEmpty() || stack2.peek() >= val) {
            stack2.push(val);
        }
    }
    
    public void pop() {
        int top = stack1.pop();
        if (!stack2.isEmpty() && stack2.peek() == top) {
            stack2.pop();
        }
    }
    
    public int top() {
        return stack1.peek();
    }
    
    public int getMin() {
        return stack2.peek();
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