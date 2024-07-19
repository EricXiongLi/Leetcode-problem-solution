class Solution {
    Map<Integer, List<Integer>> map = new HashMap();
    int time = 0;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        for (int i = 0; i < manager.length; i++) {
            //manager -> subordidate
            map.putIfAbsent(manager[i], new ArrayList());
            map.get(manager[i]).add(i); 
        }
        dfs(headID, 0, informTime);
        return time;
    }
    
    public void dfs(int id, int curTime, int[] informTime) {
        if (map.getOrDefault(id, new ArrayList()).size() == 0) {
            time = Math.max(curTime, time);
            return;
        }
        for (int nei : map.get(id)) {
            dfs(nei, curTime + informTime[id], informTime);
        }
        
    }
}

//tc: O(n)
//sc: O(n)