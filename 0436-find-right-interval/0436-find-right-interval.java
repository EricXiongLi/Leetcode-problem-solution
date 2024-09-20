class Solution {
    public int[] findRightInterval(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            list.add(new int[]{intervals[i][0], intervals[i][1], i});
        }
        Collections.sort(list, (a, b) -> (Integer.compare(a[0], b[0])));
        
        int[] res = new int[n];
        
        for (int i = 0; i < n; i++) {
            res[list.get(i)[2]] = findNearestMax(i, list);
        }
        
        return res;
    }
    
    public int findNearestMax(int i, List<int[]> list) {
        int l = i, r = list.size() - 1;
        int target = list.get(i)[1];
        while (l <= r) {
            int m = l + r >> 1;
            if (list.get(m)[0] > target) {
                r = m - 1; 
            } else if (list.get(m)[0] == target) {
                return list.get(m)[2];
            } else {
                l = m + 1;
            }
        }
        
        return l == list.size() ? -1 : list.get(l)[2];
    }
}