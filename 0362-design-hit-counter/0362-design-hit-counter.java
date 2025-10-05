class HitCounter {
    //(val, all frequency of this value)
    Deque<int[]> deque;
    int totalCount = 0;
    public HitCounter() {
        deque = new LinkedList<>();
    }
    
    public void hit(int timestamp) {
        totalCount++;
        if (!deque.isEmpty() && deque.peekLast()[0] == timestamp) {
            deque.peekLast()[1]++;
        } else {
            deque.offer(new int[]{timestamp, 1});
        }
    }
    
    public int getHits(int timestamp) {
        while (!deque.isEmpty() && timestamp - deque.peekFirst()[0] >= 300) {
            int[] remove = deque.poll();
            totalCount -= remove[1];
        }

        return totalCount;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */