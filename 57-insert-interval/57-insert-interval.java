class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList();
        
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[1] < intervals[i][0]) {
                ans.add(newInterval);
                for (int j = i; j < intervals.length; j++) {
                    ans.add(intervals[j]);
                }
                int[][] res = new int[ans.size()][2];
                for (int k = 0; k < ans.size(); k++) {
                    res[k][0] = ans.get(k)[0];
                    res[k][1] = ans.get(k)[1];
                }
                return res;
            }
            else if (newInterval[0] > intervals[i][1]) {
                ans.add(intervals[i]);
            }
            else {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            }
        }
        
        ans.add(newInterval);
        int[][] res = new int[ans.size()][2];
                for (int k = 0; k < ans.size(); k++) {
                    res[k][0] = ans.get(k)[0];
                    res[k][1] = ans.get(k)[1];
                }
        return res;
        
        
    }
}

//tc: O(n)
//sc: O(1)