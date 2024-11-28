class Solution {
    public int[] timeTaken(int[] arrival, int[] state) {
        //the persons at corresponding status befor current time;
        Queue<Integer> enterQ = new LinkedList<>();
        Queue<Integer> exitQ = new LinkedList<>();
        int n = arrival.length;
        int prevState = 1;
        int curTime = 0;
        int i = 0;
        int[] res = new int[n];
        while (i < n ||!enterQ.isEmpty() || !exitQ.isEmpty()) {
            //push all persons to their queue before current time;
            
            while (i < n && arrival[i] <= curTime) {
                if (state[i] == 1) {
                    exitQ.offer(i);
                } else {
                    enterQ.offer(i);
                }
                i++;
            }
            
            if (prevState == 1) {
                if (!exitQ.isEmpty()) {
                    res[exitQ.poll()] = curTime;
                } else if (!enterQ.isEmpty()) {
                    res[enterQ.poll()] = curTime;
                    prevState ^= 1;
                }
            } else {
                if (!enterQ.isEmpty()) {
                    res[enterQ.poll()] = curTime;
                } else if (!exitQ.isEmpty()) {
                    res[exitQ.poll()] = curTime;
                    prevState ^= 1;
                } else {
                    prevState ^= 1;
                }
            }
            
            curTime++;
        }
        
        return res;
    }
}