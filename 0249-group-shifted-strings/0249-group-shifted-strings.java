class Solution {
    
    public String hashKey(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            // not int, e.g. 10 may be 10 or diff 1 + diff 0
           char diff = (char)((s.charAt(i) - s.charAt(i - 1) + 26) % 26 + 'a');
            sb.append(diff);
        }
        return sb.toString();
    }
    public List<List<String>> groupStrings(String[] strings) {
        
       //az:0， 25 （-25 + 26）% 26
//ba         1， 0
        
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        
        for (String s: strings) {
            String hash = hashKey(s);
            
            map.putIfAbsent(hash, new ArrayList<>());
            map.get(hash).add(s);
        }
        
        for (List<String> list : map.values()) {
            res.add(list);
        }
        
        return res;
    }
}

// tc: O(N * K), K is the max length of the strings
// sc: O(N * K)