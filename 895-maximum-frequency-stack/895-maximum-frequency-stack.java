class FreqStack {
    Map<Integer, Integer> valToFreq;   // <val, freq>
    Map<Integer, Deque<Integer>> freqToVal; // <freq, values with the frequenct>
    int maxFreq;
    
    public FreqStack() {
        valToFreq = new HashMap<>();
        freqToVal = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        valToFreq.put(val, valToFreq.getOrDefault(val, 0) + 1);
        int curFreq = valToFreq.get(val);
        maxFreq = Math.max(curFreq, maxFreq);
        freqToVal.computeIfAbsent(curFreq, v-> new ArrayDeque<>()).push(val);
    }
    
    public int pop() {
        int res = freqToVal.get(maxFreq).pop();
        valToFreq.put(res, valToFreq.get(res) - 1);
        if (freqToVal.get(maxFreq).size() == 0) maxFreq--;//important corner case
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */