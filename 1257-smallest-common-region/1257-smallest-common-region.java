class Solution {
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, String> parent = new HashMap();
        Set<String> ancestors = new HashSet();
        
        for (List<String> list : regions) {
            for (int i = 1; i < list.size(); i++) {
                parent.put(list.get(i), list.get(0));
            }
        }
        String ancestor1 = region1;
        while (ancestor1 != null) {
            ancestors.add(ancestor1);
            ancestor1 = parent.get(ancestor1);
        }
        
        String ancestor2 = region2;
        while (ancestor2 != null) {
            if (ancestors.contains(ancestor2)) {
                return ancestor2;
            }
            ancestor2 = parent.get(ancestor2);
        }
        
        return ancestor2;
    }
}

//tc: O(n)
//sc: O(n)