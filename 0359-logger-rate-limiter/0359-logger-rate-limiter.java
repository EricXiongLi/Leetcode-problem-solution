class Logger {
    int latestTime = 0;
    Map<String, Integer> map;
    public Logger() {
        map = new LinkedHashMap<String, Integer>(){
            protected boolean removeEldestEntry(Map.Entry<String, Integer> entry) {
                return latestTime - entry.getValue() > 10;
            }
        };
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        latestTime = timestamp;
        if (map.get(message) != null && timestamp - map.get(message) < 10) {
            return false;
        }
        map.put(message, timestamp);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */

//tc: O(1). O(N)
//sc: O(M), m is the maximum size of meesages within 10 sec