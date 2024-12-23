class Solution {
    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer> dist = new HashMap<>();
        int n = points.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int dis = calculate(points[i], points[j]);
                    dist.put(dis, dist.getOrDefault(dis, 0) + 1);
                }
            }
            for (int val : dist.values()) {
                if (val >= 2) {
                    res += val * (val - 1);
                }
            }
            dist.clear();
        }

        return res;
    }

    public int calculate(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}