class StockPrice {
    
    int cur;
    Map<Integer, Integer> map; //timestamp, price
    TreeMap<Integer, Integer> tm; // price, 
    
    public StockPrice() {
        cur = 0;
        map = new HashMap<>();
        tm = new TreeMap<>();
    }
    
    public void update(int timestamp, int price) {
        cur = Math.max(cur, timestamp);
        if (!map.containsKey(timestamp)) {
            map.put(timestamp, price);
            tm.put(price, tm.getOrDefault(price, 0) + 1);
        } else {
            int oldPrice = map.get(timestamp);
            map.put(timestamp, price);
            tm.put(oldPrice, tm.get(oldPrice) - 1);
            if (tm.get(oldPrice) == 0) {
                tm.remove(oldPrice);
            }
            tm.put(price, tm.getOrDefault(price, 0) + 1);
        }
    }
    
    public int current() {
        return map.get(cur);
    }
    
    public int maximum() {
        return tm.lastKey();
    }
    
    public int minimum() {
        return tm.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */