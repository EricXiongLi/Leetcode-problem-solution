class MovingAverage {
    Deque<Integer> dq = new LinkedList<>();
    int sum;
    int sz;
    public MovingAverage(int size) {
        sz = size;
        sum = 0;
    }
    
    public double next(int val) {
        dq.offer(val);
        sum += val;
        if (dq.size() > sz) {
            int head = dq.poll();
            sum -= head;
        }
        return (double) sum / dq.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */