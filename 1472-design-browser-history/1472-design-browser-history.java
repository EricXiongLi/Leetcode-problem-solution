class BrowserHistory {
    Deque<String> temp = new LinkedList<>();
    Deque<String> cur = new LinkedList<>();
    public BrowserHistory(String homepage) {
        cur.push(homepage);
    }
    
    public void visit(String url) {
        temp.clear();
        cur.push(url);
    }
    
    public String back(int steps) {
        int count = Math.min(steps, cur.size() - 1);

        for (int i = 0; i < count; i++) {
            temp.push(cur.pop());
        }

        return cur.peek();
    }
    
    public String forward(int steps) {
        int count = Math.min(temp.size(), steps);

        for (int i = 0; i < count; i++) {
            cur.push(temp.pop());
        }

        return cur.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */