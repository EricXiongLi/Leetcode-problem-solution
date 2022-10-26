class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        int p1 = 0, p2 =  0;
        int n1 = slots1.length, n2 = slots2.length;
        List<Integer> res = new ArrayList<>();
        Arrays.sort(slots1, (a, b) -> a[0] - b[0]);
        Arrays.sort(slots2, (a, b) -> a[0] - b[0]);
        while (p1 < n1 && p2 < n2) {
            int start1 = slots1[p1][0], end1 = slots1[p1][1];
            int start2 = slots2[p2][0], end2 = slots2[p2][1];
            //             [   ]
            // []          [   ] []
            if (start1 > end2) {
                p2++;
            } else if (start2 > end1) {
                p1++;
            } else {
                if (Math.max(start1, start2) + duration <= Math.min(end1, end2)) {
                    res.add(Math.max(start1, start2));
                    res.add(Math.max(start1, start2) + duration);
                    return res;
                } else if (end1 > end2) {
                    p2++;
                } else {
                    p1++;
                }
            }
        }
        return res;
    }
}