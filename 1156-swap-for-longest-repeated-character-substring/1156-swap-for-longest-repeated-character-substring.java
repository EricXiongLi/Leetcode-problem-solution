class Solution {
    public int maxRepOpt1(String text) {
        int[] count = new int[26];
        for (char c : text.toCharArray()) {
            count[c - 'a']++;
        }
        
        int start = 0;
        int res = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap();
        for (int end = 0; end < text.length(); end++) {
            char c = text.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (!isFine(map)) {
                map.put(text.charAt(start), map.get(text.charAt(start)) - 1);
                if (map.get(text.charAt(start)) == 0) {
                    map.remove(text.charAt(start));
                }
                start++;
            }
            
            if (map.size() == 1 || isOk(text, start, end, map, count)) {
                res = Math.max(res, end - start + 1);
            }
        }
        return res;
    }
    
    public boolean isFine(Map<Character, Integer> map) {
        if (map.size() > 2) {
            return false;
        }
        if (map.size () == 1) {
            return true;
        }
        int[] num = new int[2];
        int i = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            num[i] = entry.getValue();
            i++;
        }
        if (num[0] > 1 && num[1] > 1) {
            return false;
        }
        return true;
    }
    
    public boolean isOk(String text, int start, int end, Map<Character, Integer> map, int[] count) {
        char[] arr = new char[2];
        int i = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            arr[i] = entry.getKey();
            i++;
        }
        char less, more;
        if (map.get(arr[0]) <= map.get(arr[1])) {
            less = arr[0];
            more = arr[1];
        } else {
            less = arr[1];
            more = arr[0];
        }
        if (count[more - 'a'] >= map.get(more) + 1) {
            return true;
        }
        return false;
    }
}