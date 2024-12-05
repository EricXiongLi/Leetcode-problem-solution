class Solution {
    public List<Integer> partitionLabels(String s) {
        int[][] intervals = new int[26][2];
        for (int[] arr : intervals) {
            Arrays.fill(arr, -1);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int pos = c - 'a';
            if (intervals[pos][0] == -1) {
                intervals[pos][0] = i;
                intervals[pos][1] = i;
            } else {
                intervals[pos][1] = i;
            }
        }
        
        Arrays.sort(intervals, (a, b) -> (a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1])));
        int prevStart = -1;
        int prevEnd = -1;
        int firstIndex = 26;
        for (int i = 0; i < 26; i++) {
            if (intervals[i][0] != - 1) {
                prevStart = intervals[i][0];
                prevEnd = intervals[i][1];
                firstIndex = i;
                break;
            }
        }
        List<Integer> res = new ArrayList<>();
        
        for (int i = firstIndex + 1; i < 26; i++) {
            if (intervals[i][0] != -1) {
                if (intervals[i][0] > prevEnd) {
                res.add(prevEnd - prevStart + 1);
                prevStart = intervals[i][0];
                prevEnd = intervals[i][1];
                } else {
                    prevEnd = Math.max(intervals[i][1], prevEnd);
                }
            }
        }
        
        res.add(prevEnd - prevStart + 1);
        
        return res;
        
        
        
    }
}

//tc: O(nlogn)
//sc: O(logn)