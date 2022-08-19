class Solution {
    Integer[] rootSum;
    public int countHighestScoreNodes(int[] parents) {
        int n = parents.length;
        rootSum = new Integer[n];
        Map<Integer, List<Integer>> children = new HashMap<>();
        for (int i = 0; i < n; i++) {
            children.computeIfAbsent(parents[i], v -> new ArrayList<Integer>()).add(i);
        }
        for (int i = 0; i < n; i++) {
            getSum(children, i);
        }
        int totalSum = Collections.max(Arrays.asList(rootSum));
        long res = 0;
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!children.containsKey(i)) {
                if (totalSum - 1 >= res) {
                    res = totalSum - 1;
                    map.put(res, map.getOrDefault(res, 0) + 1) ;
                }
            } else if (children.get(i).size() == 1) {
                long childNum = rootSum[children.get(i).get(0)];
                long subAns = 0;
                if (totalSum - childNum - 1 == 0) {
                    subAns = childNum;
                } else {
                    subAns = childNum * (totalSum - childNum - 1);
                }
                if (subAns >= res) {
                    res = subAns;
                }
                map.put(subAns, map.getOrDefault(subAns, 0) + 1);
            } else {
                long leftSum = rootSum[children.get(i).get(0)];
                long rightSum = rootSum[children.get(i).get(1)];
                long subAns = 0;
                if (totalSum - leftSum - rightSum - 1 == 0) {
                    subAns = leftSum * rightSum;
                } else {
                    subAns = leftSum * rightSum * (totalSum - leftSum - rightSum - 1);
                }
                if (subAns >= res) {
                    res = subAns;
                }
                map.put(subAns, map.getOrDefault(subAns, 0) + 1) ;
            }
        }
        return map.get(res);
    }
    
    private int getSum(Map<Integer, List<Integer>> children, int cur) {
        if (!children.containsKey(cur)) {
            rootSum[cur] = 1;
            return 1;
        }
        if (rootSum[cur] != null) return rootSum[cur];
        int sum = 1;
        for (int child : children.get(cur)) {
            sum += getSum(children, child);
        }
        rootSum[cur] = sum;
        return rootSum[cur];
    }
}
