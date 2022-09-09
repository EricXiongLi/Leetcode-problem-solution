class RandomizedSet {
    int N = 200001;
    int[] nums = new int[N];
    int sz = 0;
    Map<Integer, Integer> map;//<val, loc>
    public RandomizedSet() {
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        nums[sz] = val;
        map.put(val, sz);
        sz++;
        return true;
    }
    //[1, 2]
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int loc = map.get(val);
        nums[loc] = nums[sz - 1];
        if (sz - 1 != loc) {
            map.put(nums[sz - 1], loc);
        }
        sz--;
        map.remove(val);
        
        return true;
    }
    
    public int getRandom() {
        Random random = new Random();
        int loc = random.nextInt(sz);
        int value = nums[loc];
        return nums[loc];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */