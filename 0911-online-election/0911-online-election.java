class TopVotedCandidate {
    //person -> times
    Map<Integer, Integer> count = new HashMap();
    
    //time -> leading person
    TreeMap<Integer, Integer> map = new TreeMap();
    
    public TopVotedCandidate(int[] persons, int[] times) {
        int lead = -1;
        for (int i = 0; i < times.length; i++) {
            count.put(persons[i], count.getOrDefault(persons[i], 0) + 1);
            if (count.get(persons[i]) >= (lead == -1 ? 0 : count.get(lead))) {
                lead = persons[i];
            }
            map.put(times[i], lead);
        }
    }
    
    public int q(int t) {
        return map.floorEntry(t).getValue();
    }
    
    //tc: O(N logN)
    //sc: O(N)
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */