class RandomizedSet {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    public RandomizedSet() {
        
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            map.put(val, list.size());
            list.add(val);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int idx = map.get(val);
        list.set(idx, list.get(list.size() - 1));
        int last = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        map.remove(val);
        map.put(last, idx);
        return true;
    }
    
    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */