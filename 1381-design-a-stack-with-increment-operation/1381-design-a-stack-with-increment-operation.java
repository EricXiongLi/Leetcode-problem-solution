class CustomStack {
    
    int capacity;
    int[] inc;
    Stack<Integer> stack;
    
    

    public CustomStack(int maxSize) {
        capacity = maxSize;
        inc = new int[maxSize];
        stack = new Stack<>();
    }
    
    public void push(int x) {
        if (stack.size() >= capacity) return;
        stack.push(x);
        int i = stack.size() - 1;
        inc[i] = 0;
    }
    
    public int pop() {
        int i = stack.size() - 1;
        if (i < 0) return -1;
        int original = stack.pop();
        if (i >= 1) inc[i - 1] += inc[i];
        return original + inc[i];
        
    }
    
    public void increment(int k, int val) {
        int pos = Math.min(k, stack.size()) -1;
        if (pos >= 0) inc[pos] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */