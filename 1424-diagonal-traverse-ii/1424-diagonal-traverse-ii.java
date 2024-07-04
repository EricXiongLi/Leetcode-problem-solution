class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.offer(new Pair(0, 0));
        List<Integer> res = new ArrayList<>();
        // BFS
        while (!q.isEmpty()) {
            Pair<Integer, Integer> pair = q.poll();
            int row = pair.getKey();
            int col = pair.getValue();
            res.add(nums.get(row).get(col));
            //only the first element need to add the "below" item
            if (col == 0 && row + 1 < nums.size()) {
                q.offer(new Pair(row + 1, col));
            }
            //add children
            if (col + 1 < nums.get(row).size()) {
                q.offer(new Pair(row, col + 1));
            }
        }
        
        int[] ans = new int[res.size()];
        
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        
        return ans;   
    }
}

//tc: O(n)
//sc: O(√n)