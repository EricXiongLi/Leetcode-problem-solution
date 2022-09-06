class BrowserHistory {
    Deque<String> backward = new ArrayDeque<>();
    Deque<String> forward = new ArrayDeque<>();
    
    public BrowserHistory(String homepage) {
        backward.push(homepage);
    }
    
    public void visit(String url) {
        forward.clear();
        backward.push(url);
    }
    
    public String back(int steps) {
        int sz = backward.size();
        for (int i = 0; i < Math.min(sz - 1, steps); i++) {
            String s = backward.pop();
            forward.push(s);
        }
        return backward.peekFirst();
    }
    
    public String forward(int steps) {
        int sz = forward.size();
        for (int i = 0; i < Math.min(steps, sz); i++) {
            String s = forward.pop();
            backward.push(s);
        }
        return backward.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */