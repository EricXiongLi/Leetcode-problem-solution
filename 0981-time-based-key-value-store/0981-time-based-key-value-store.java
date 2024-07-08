class TimeMap {
    Map<String, ArrayList<Pair<Integer, String>>> map;
        
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList());
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        
        ArrayList<Pair<Integer, String>> list = map.get(key);
        
        if (list.get(0).getKey() > timestamp) {
            return "";
        }
        
        int l = 0, r = list.size() - 1;
        //<, <, [<], >, >, >
        //l                r
        //      m
        //          l
        //              m
        //          r
        //          m
        //      l
        //
        while (l <= r) {
            int mid = l + r >> 1;
            if (list.get(mid).getKey() <= timestamp) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return list.get(r).getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */