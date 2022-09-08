class FirstUnique {
    //
    Queue<Integer> q = new ArrayDeque<>();
    Map<Integer, Boolean> map = new HashMap<>();//<val, isUnique>
    
    public FirstUnique(int[] nums) {
        for (int num : nums) {
            add(num);
        }
    }
    
    public int showFirstUnique() {
        while (!q.isEmpty() && !map.get(q.peek())) {
            q.poll();
        }
        if (!q.isEmpty()) {
            return q.peek();
        }
        return -1;
    }
    
    public void add(int value) {
        if (map.containsKey(value)) {
            q.offer(value);
            map.put(value, false);
        } else {
            q.offer(value);
            map.put(value, true);
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */