class Solution {
    int res = Integer.MAX_VALUE;
    public int minSessions(int[] tasks, int sessionTime) {
        int count = 0;
        int[] sessionTasks = new int[tasks.length];
        Arrays.sort(tasks);
        dfs(tasks, sessionTime, 1, tasks.length - 1, sessionTasks);
        return res;
        
    }
    
    private void dfs(int[] tasks, int sessionTime, int curSession, int curPos, int[] sessionTasks) {
        if (curPos == -1) {
            res = Math.min(res, curSession);
            return;
        }
        if (curSession > res) return;
        for (int i = 0; i < curSession; i++) {
            if (sessionTasks[i] + tasks[curPos] <= sessionTime) {
                sessionTasks[i] += tasks[curPos];
                dfs(tasks, sessionTime, curSession, curPos - 1, sessionTasks);
                sessionTasks[i] -= tasks[curPos];
            }
        }
        curSession++;
        if (curSession > res || curSession > tasks.length) return;
        sessionTasks[curSession - 1] = tasks[curPos];
        dfs(tasks, sessionTime, curSession, curPos - 1, sessionTasks);
        sessionTasks[curSession - 1] = 0;
    }
}