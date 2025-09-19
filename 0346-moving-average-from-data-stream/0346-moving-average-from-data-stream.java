class MovingAverage {
    Queue<Integer> q = new LinkedList<>();
    int size;
    int sum;
    public MovingAverage(int size) {
        this.size = size;
        sum = 0;
    }
    
    public double next(int val) {
        q.offer(val);
        sum += val;
        if (q.size() > size) {
            sum -= q.poll();
        }
        return (double) sum / q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */