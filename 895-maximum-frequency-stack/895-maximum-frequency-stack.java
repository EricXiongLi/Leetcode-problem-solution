class FreqStack {
    Map<Integer, Integer> freq; //val, frequency
    PriorityQueue<int[]> pq; //val, freq, sequenceID
    int pushCount;
    
    public FreqStack() {
        freq = new HashMap<>();
        pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? b[2] - a[2] : b[1] - a[1]);
        pushCount = 0;
    }
    
    public void push(int val) {
        freq.put(val, freq.getOrDefault(val, 0) + 1);
        pq.offer(new int[]{val, freq.get(val), ++pushCount});
    }
    
    public int pop() {
        //pop 
        int res = pq.poll()[0];
        //reduce frequency
        freq.put(res, freq.get(res) - 1);
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */